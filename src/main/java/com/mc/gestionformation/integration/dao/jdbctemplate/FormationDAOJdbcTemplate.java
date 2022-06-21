package com.mc.gestionformation.integration.dao.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormationDTO;
import com.mc.gestionformation.integration.dao.IFormationDAO;
import com.mc.gestionformation.model.Formation;

@Repository
public class FormationDAOJdbcTemplate implements IFormationDAO {

	private static Logger logger = LoggerFactory.getLogger(FormationDAOJdbcTemplate.class);

	private static final String TABLE_NAME_FORMATION = "FORMATION_TEST";

	private class FormationMapper implements RowMapper<Formation> {

		@Override
		public Formation mapRow(ResultSet rs, int rowNum) throws SQLException {
			Formation formation = new Formation();
			formation.setId(rs.getLong("ID"));
			formation.setTitre(rs.getString("TITRE"));
			formation.setCode(rs.getString("CODE"));
			return formation;

		};

	}

	@Autowired
	JdbcTemplate jdbcTempate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public FormationDTO create(FormationDTO dto) {
		Formation formation = dto.getFormation();
		String sql = "INSERT INTO " + TABLE_NAME_FORMATION + " (ID, TITRE, CODE) values (?,?,?)";
		jdbcTempate.update(sql, formation.getId(), formation.getTitre(), formation.getCode());
		return dto;
	}

	@Override
	public FormationDTO update(FormationDTO dto) {
		Formation formation = dto.getFormation();
		String sql = "UPDATE " + TABLE_NAME_FORMATION + " SET TITRE = ?, CODE= ? WHERE ID = ?";
		jdbcTempate.update(sql, formation.getTitre(), formation.getCode(), formation.getId());

		return dto;
	}

	@Override
	public FormationDTO delete(FormationDTO dto) {

		Formation formation = dto.getFormation();
		String sql = "DELETE " + TABLE_NAME_FORMATION + " WHERE ID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", formation.getId());
		namedJdbcTemplate.update(sql, /* params */ Map.of("id", formation.getId()));
		return dto;

	}

	@Override
	public FormationDTO deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormationDTO findById(Long id) {

		FormationDTO formationDTO = new FormationDTO();

		String sql = " SELECT * FROM " + TABLE_NAME_FORMATION + " WHERE ID = ?";

//		RowMapper<Formation> formationMapper = (rs, num) -> {
//			Formation formation = new Formation();
//			formation.setId(rs.getLong("ID"));
//			formation.setNom(rs.getString("CODE"));
//			formation.setPrenom(rs.getString("TITRE"));
//			return formation;
//
//		};

		Formation formation = this.jdbcTempate.queryForObject(sql, new FormationMapper(), id);

		formationDTO.setFormation(formation);

		return formationDTO;
	}

	@Override
	public FormationDTO findAll() {

		FormationDTO formationDTO = new FormationDTO();
		List<Formation> formations = new ArrayList<>();
		String sql = " SELECT * FROM " + TABLE_NAME_FORMATION;
		List<Map<String, Object>> result = this.jdbcTempate.queryForList(sql);

		for (Map<String, Object> ligne : result) {
			Formation formation = new Formation();
			formation.setId((Long) ligne.get("ID"));
			formation.setCode((String) ligne.get("CODE"));
			formation.setTitre((String) ligne.get("TITRE"));

			formations.add(formation);

		}

		return formationDTO;
	}

	public long count() {

		String sql = " SELECT count(*) FROM " + TABLE_NAME_FORMATION;
		long result = this.jdbcTempate.queryForObject(sql, Long.class);
		return result;

	}

	public long count2() {

		String sql = " SELECT * FROM " + TABLE_NAME_FORMATION;
		RowCountCallbackHandler rowCount = new RowCountCallbackHandler();
		this.jdbcTempate.query(sql, new RowCountCallbackHandler());
		long result = rowCount.getRowCount();
		return result;

	}

	public String getFormationAsHtml(Long id) {

		StringBuilder formationAsHtml = new StringBuilder();

		RowCallbackHandler formationHandler = new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {

				formationAsHtml.append("<html>");
				formationAsHtml.append("<body>");

				formationAsHtml.append("<P> id : " + rs.getLong("ID"));
				formationAsHtml.append("<P> nom : " + rs.getString("CODE"));
				formationAsHtml.append("<P> prenom : " + rs.getString("TITRE"));

				formationAsHtml.append("</body>");
				formationAsHtml.append("</html>");

			}

		};

		String sql = "SELECT * FROM " + TABLE_NAME_FORMATION + " WHERE ID = ?";
		jdbcTempate.query(sql, new Object[] { 1L }, formationHandler);

		return formationAsHtml.toString();

	}

	@Override
	public FormationDTO findFormationByFormateur(FormationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormationDTO findFormationByDiscipline(FormationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
