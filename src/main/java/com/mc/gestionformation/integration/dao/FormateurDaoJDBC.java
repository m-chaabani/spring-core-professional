package com.mc.gestionformation.integration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

@Repository
public class FormateurDaoJDBC implements IFormateurDAO {
	private static Logger logger = LoggerFactory.getLogger(FormateurDaoJDBC.class);

	@Inject
	DataSource dataSource;
	

	public Object save(Object o) {
		return 1;
	}

	@Override
	public FormateurDTO create(FormateurDTO dto) {
		
		// logger.info("Executing Create on " + dto.toString());
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
		
			
			// translation
			//throw new E(); ORA-00001 : Primary Key Violation
			// logger.error("Exception in Create Method on " + dto.toString());
		} catch (Exception exception) {
			dto.setHasErros(true);
			dto.getErreurs().add(exception);
			// logger.error("Exception in Create Method on " + dto.toString());
		}
		// logger.info("finishing Create Method on " + dto.toString());
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

	@Override
	public FormateurDTO deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public FormateurDTO findById(Long id) {
		ResultSet rs = null;
		PreparedStatement pst = null;
		FormateurDTO dto = new FormateurDTO();
		try (Connection conn = dataSource.getConnection();) {

			pst = conn.prepareStatement("SELECT * FROM FORMATEUR WHERE ID = ?");
			pst.setLong(1, 1L);
			rs = pst.executeQuery();

			while (rs.next()) {
				Long ID = rs.getLong("ID");
				String firstName = rs.getString("FIRST_NAME");
				String LastName = rs.getString("LAST_NAME");
				Formateur formateur = new Formateur();
				formateur.setId(ID);
				formateur.setNom(LastName);
				formateur.setPrenom(firstName);
				dto.setFormateur(formateur);
				break;

			}

		} catch (SQLException sqlException) {
			dto.setHasErros(true);
			dto.getErreurs().add(sqlException);
			sqlException.printStackTrace();
		} catch (Exception exception) {
			dto.setHasErros(true);
			dto.getErreurs().add(exception);
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dto;

	}

	@Override
	public FormateurDTO findByDiscipline(FormateurDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
