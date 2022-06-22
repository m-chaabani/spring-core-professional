package com.mc.gestionformation.integration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;

@Repository
public class FormateurDaoJDBC implements IFormateurDAO {
	private static Logger logger = LoggerFactory.getLogger(FormateurDaoJDBC.class);

	@Inject
	DataSource dataSource;

	private static String TABLE_NAME = "FORMATEUR_TEST";

	@Override
	public Formateur create(Formateur formateur) {

		try (Connection conn = dataSource.getConnection();) {

			String sql = "INSERT INTO " + TABLE_NAME + " (FIRST_NAME, LAST_NAME  ";
			if (formateur.getId() != null) {
				sql += " , ID ) VALUES (?,?,?)";
			} else {
				sql += " ) VALUES (?,?)";
			}

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(3, formateur.getId());
			pst.setString(1, formateur.getPrenom());
			pst.setString(2, formateur.getNom());
			pst.executeUpdate();

		} catch (Exception exception) {
			throw new RuntimeException(exception.getMessage());
		}

		return formateur;
	}

	@Override
	public Formateur update(Formateur formateur) {
		int impactedRows = 0;
		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn
					.prepareStatement("UPDATE " + TABLE_NAME + " SET FIRST_NAME = ?, LAST_NAME = ? WHERE ID = ?");
			pst.setString(1, formateur.getPrenom());
			pst.setString(2, formateur.getNom());

			pst.setLong(3, formateur.getId());

			impactedRows = pst.executeUpdate();

		} catch (Exception exception) {
			new RuntimeException(exception);
		}

		return formateur;
	}

	@Override
	public boolean delete(Formateur formateur) {
		int impactedRows = 0;
		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn.prepareStatement("DELETE FROM " + TABLE_NAME + "   WHERE ID = ? ");
			pst.setLong(1, formateur.getId());

			impactedRows = pst.executeUpdate();

		} catch (Exception exception) {
			new RuntimeException(exception);
		}

		return !(impactedRows == 0);

	}

	@Override
	public boolean deleteById(Long id) {
		int impactedRows = 0;
		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn.prepareStatement("DELETE FROM " + TABLE_NAME + "   WHERE ID = ? ");
			pst.setLong(1, id);

			impactedRows = pst.executeUpdate();

		} catch (Exception exception) {
			new RuntimeException(exception);
		}

		return !(impactedRows == 0);
	}

	@Override
	public List<Formateur> findAll() {
		List<Formateur> formateursResultatRecherche = new ArrayList<>();

		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + TABLE_NAME);
			ResultSet rs = pst.executeQuery();

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

		} catch (Exception exception) {
			new RuntimeException(exception);
		}

		return formateursResultatRecherche;
	}

	@Override
	public Optional<Formateur> findById(Long id) {

		Formateur formateur = new Formateur();
		try (Connection conn = dataSource.getConnection();) {

			PreparedStatement pst = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + "  WHERE ID = ?");
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Long ID = rs.getLong("ID");
				String firstName = rs.getString("FIRST_NAME");
				String LastName = rs.getString("LAST_NAME");

				formateur.setId(ID);
				formateur.setNom(LastName);
				formateur.setPrenom(firstName);
				break;

			}

		} catch (Exception exception) {
			new RuntimeException(exception);
		}

		return Optional.ofNullable(formateur);

	}

	@Override
	public FormateurDTO findByDiscipline(FormateurDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
