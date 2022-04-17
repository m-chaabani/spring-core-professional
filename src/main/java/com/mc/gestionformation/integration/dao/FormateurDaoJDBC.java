package com.mc.gestionformation.integration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

@Repository
public class FormateurDaoJDBC implements IFormateurDao {

	@Inject
	@Qualifier("dataSourceByEnv")
	DataSource dataSource;

	public Object save(Object o) {
		return 1;
	}


	@Override
	public FormateurDTO create(FormateurDTO dto) {
		try (Connection conn = dataSource.getConnection();) {

			String sql = "INSERT INTO FORMATEUR (FIRST_NAME, LAST_NAME  ";
			if (dto.getFormateur().getId() != null) {
				sql += " , ID ) VALUES (?,?,?)";
			} else {
				sql += " ) VALUES (?,?)";
			}

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(3, dto.getFormateur().getId());
			pst.setString(1, dto.getFormateur().getPrenom());
			pst.setString(2, dto.getFormateur().getNom());
			pst.executeUpdate();

		} catch (SQLException sqlException) {
			dto.setHasErros(true);
			dto.getErreurs().add(sqlException);
			sqlException.printStackTrace();
		} catch (Exception exception) {
			dto.setHasErros(true);
			dto.getErreurs().add(exception);
		}

		return dto;
	}

	@Override

	public FormateurDTO update(FormateurDTO dto) {
		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn
					.prepareStatement("UPDATE FORMATEUR SET FIRST_NAME = ?, LAST_NAME = ? WHERE ID = ?");
			pst.setString(1, dto.getFormateur().getPrenom());
			pst.setString(2, dto.getFormateur().getNom());

			pst.setLong(3, dto.getFormateur().getId());

			pst.executeUpdate();

		} catch (SQLException sqlException) {
			dto.setHasErros(true);
			dto.getErreurs().add(sqlException);
			sqlException.printStackTrace();
		} catch (Exception exception) {
			dto.setHasErros(true);
			dto.getErreurs().add(exception);
		}

		return dto;
	}

	@Override

	public FormateurDTO delete(FormateurDTO dto) {
		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn.prepareStatement("DELETE FROM FORMATEUR  WHERE ID = ? ");
			pst.setLong(1, dto.getFormateur().getId());

			pst.executeUpdate();

		} catch (SQLException sqlException) {
			dto.setHasErros(true);
			dto.getErreurs().add(sqlException);
			sqlException.printStackTrace();
		} catch (Exception exception) {
			dto.setHasErros(true);
			dto.getErreurs().add(exception);
		}

		return dto;

	}


	public FormateurDTO findById(FormateurDTO dto) {
		return dto;

	}

	@Override
	public FormateurDTO findAll() {
		FormateurDTO dto = new FormateurDTO();
		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn.prepareStatement("SELECT * FROM FORMATEUR");
			ResultSet rs = pst.executeQuery();
			List<Formateur> formateursResultatRecherche = new ArrayList<>();

			while (rs.next()) {
				Long id = rs.getLong("ID");
				String firstName = rs.getString("FIRST_NAME");
				String LastName = rs.getString("LAST_NAME");
				Formateur formateur = new Formateur();
				formateur.setId(id);
				formateur.setNom(LastName);
				formateur.setPrenom(firstName);

				formateursResultatRecherche.add(formateur);
			}

			dto.setFormateurs(formateursResultatRecherche);
		} catch (SQLException sqlException) {
			dto.setHasErros(true);
			dto.getErreurs().add(sqlException);
			sqlException.printStackTrace();
		} catch (Exception exception) {
			dto.setHasErros(true);
			dto.getErreurs().add(exception);
		}

		return dto;
	}

}
