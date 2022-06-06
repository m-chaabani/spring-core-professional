package com.mc.gestionformation.integration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.model.Formation;

@Repository
public class FormateurDAOJdbcTemplate implements IFormateurDAO {

	private static final String TABLE_NAME_FORMATEUR = "FORMATEUR_TEST";
	private static final String TABLE_NAME_FORMATION = "FORMATION_TEST";

	private class FormateurMapper implements RowMapper<Formateur> {

		@Override
		public Formateur mapRow(ResultSet rs, int rowNum) throws SQLException {
			Formateur formateur = new Formateur();
			formateur.setId(rs.getLong("ID"));
			formateur.setNom(rs.getString("LAST_NAME"));
			formateur.setPrenom(rs.getString("FIRST_NAME"));
			return formateur;

		};

	}

	@Autowired
	JdbcTemplate jdbcTempate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public FormateurDTO create(FormateurDTO dto) {
		Formateur formateur = dto.getFormateur();
		String sql = "INSERT INTO " + TABLE_NAME_FORMATEUR + " (ID, FIRST_NAME, LAST_NAME) values (?,?,?)";
		try {
			jdbcTempate.update(sql, formateur.getId(), formateur.getPrenom(), formateur.getNom());
		} catch (DataAccessException e) {
			dto.setHasErros(true);
			dto.getErreurs().add(e);
			throw e;

		}

		return dto;
	}

	@Override
	public FormateurDTO update(FormateurDTO dto) {
		Formateur formateur = dto.getFormateur();
		String sql = "UPDATE " + TABLE_NAME_FORMATEUR + " SET FIRST_NAME = ?, LAST_NAME= ? WHERE ID = ?";
		jdbcTempate.update(sql, formateur.getPrenom(), formateur.getNom(), formateur.getId());

		return dto;
	}

	@Override
	public FormateurDTO delete(FormateurDTO dto) {

		Formateur formateur = dto.getFormateur();
		String sql = "DELETE " + TABLE_NAME_FORMATEUR + " WHERE ID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", formateur.getId());
		namedJdbcTemplate.update(sql, /* params */ Map.of("id", formateur.getId()));
		return dto;

	}

	@Override
	public FormateurDTO deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormateurDTO findById(Long id) {

		FormateurDTO formateurDTO = new FormateurDTO();

		String sql = " SELECT * FROM " + TABLE_NAME_FORMATEUR + " WHERE ID = ?";

//		RowMapper<Formateur> formateurMapper = (rs, num) -> {
//			Formateur formateur = new Formateur();
//			formateur.setId(rs.getLong("ID"));
//			formateur.setNom(rs.getString("LAST_NAME"));
//			formateur.setPrenom(rs.getString("FIRST_NAME"));
//			return formateur;
//
//		};

		Formateur formateur = this.jdbcTempate.queryForObject(sql, new FormateurMapper(), id);

		formateurDTO.setFormateur(formateur);

		return formateurDTO;
	}

	@Override
	public FormateurDTO findAll() {

		FormateurDTO formateurDTO = new FormateurDTO();
		List<Formateur> formateurs = new ArrayList<>();
		formateurDTO.setFormateurs(formateurs);
		String sql = " SELECT * FROM " + TABLE_NAME_FORMATEUR;
		List<Map<String, Object>> result = this.jdbcTempate.queryForList(sql);

		for (Map<String, Object> ligne : result) {
			Formateur formateur = new Formateur();
			formateur.setId((Long) ligne.get("ID"));
			formateur.setNom((String) ligne.get("LAST_NAME"));
			formateur.setPrenom((String) ligne.get("FIRST_NAME"));

			formateurs.add(formateur);

		}

		return formateurDTO;
	}

	public FormateurDTO findAll2() {

		FormateurDTO formateurDTO = new FormateurDTO();

		String sql = " SELECT * FROM " + TABLE_NAME_FORMATEUR;
		List<Formateur> formateurs = this.jdbcTempate.query(sql, new FormateurMapper());
		formateurDTO.setFormateurs(formateurs);

		return formateurDTO;
	}

	@Override
	public FormateurDTO findByDiscipline(FormateurDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {

		String sql = " SELECT count(*) FROM " + TABLE_NAME_FORMATEUR;
		long result = this.jdbcTempate.queryForObject(sql, Long.class);
		return result;

	}

	public long count2() {

		String sql = " SELECT * FROM " + TABLE_NAME_FORMATEUR;
		RowCountCallbackHandler rowCount = new RowCountCallbackHandler();
		this.jdbcTempate.query(sql, new RowCountCallbackHandler());
		long result = rowCount.getRowCount();
		return result;

	}

	public String getFormateurAsHtml(Long id) {

		StringBuilder formateurAsHtml = new StringBuilder();

		RowCallbackHandler formateurHandler = new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {

				formateurAsHtml.append("<html>");
				formateurAsHtml.append("<body>");

				formateurAsHtml.append("<P> id : " + rs.getLong("ID"));
				formateurAsHtml.append("<P> nom : " + rs.getString("LAST_NAME"));
				formateurAsHtml.append("<P> prenom : " + rs.getString("FIRST_NAME"));

				formateurAsHtml.append("</body>");
				formateurAsHtml.append("</html>");

			}

		};

		String sql = "SELECT * FROM " + TABLE_NAME_FORMATEUR + " WHERE ID = ?";
		jdbcTempate.query(sql, new Object[] { 1L }, formateurHandler);

		return formateurAsHtml.toString();

	}

	public FormateurDTO getFormateurFormation(Long id) {

		ResultSetExtractor<FormateurDTO> formateurFormationExtractor = new ResultSetExtractor<FormateurDTO>() {

			@Override
			public FormateurDTO extractData(ResultSet rs) throws SQLException, DataAccessException {
				FormateurDTO dto = new FormateurDTO();
				Formateur formateur = new Formateur();
				List<Formation> formations = new ArrayList<Formation>();

				int i = 0;

				while (rs.next()) {
					if (i == 0) {
						formateur.setId((Long) rs.getLong("id_formateur"));
						formateur.setNom((String) rs.getString("LAST_NAME"));
						formateur.setPrenom((String) rs.getString("FIRST_NAME"));

						i++;
					}
					Formation formation = new Formation();
					formation.setCode(rs.getString("CODE"));
					formation.setTitre(rs.getString("TITRE"));
					formations.add(formation);

				}
				dto.setFormateur(formateur);
				dto.setFormations(formations);

				return dto;

			}

		};

		String sql = "SELECT t.id as id_formateur, f.id as id_formation, t.*,f.* FROM " + TABLE_NAME_FORMATEUR + " t "
				+ "inner join " + TABLE_NAME_FORMATION + " f  on f.id_formateur = t.id" + " WHERE t.ID = ?";
		return jdbcTempate.query(sql, new Object[] { 1L }, formateurFormationExtractor);

	}

}
