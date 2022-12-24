package com.mc.gestionformation.integration.dao.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.IFormateurDAO;
import com.mc.gestionformation.model.Formateur;
import com.mc.gestionformation.model.Formation;

@Repository
@Primary
public class FormateurDAOJdbcTemplate implements IFormateurDAO {

	private static Logger logger = LoggerFactory.getLogger(FormateurDAOJdbcTemplate.class);

	private static final String TABLE_NAME_FORMATEUR = "FORMATEUR";
	private static final String TABLE_NAME_FORMATION = "FORMATION";

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
	public Formateur create(Formateur formateur) {

		String sql = "INSERT INTO " + TABLE_NAME_FORMATEUR + " (ID, FIRST_NAME, LAST_NAME) values (?,?,?)";
		int impactedRows = jdbcTempate.update(sql, formateur.getId(), formateur.getPrenom(), formateur.getNom());
		return (impactedRows==0)?null:formateur;
	}

	@Override
	public Formateur update(Formateur formateur) {
		String sql = "UPDATE " + TABLE_NAME_FORMATEUR + " SET FIRST_NAME = ?, LAST_NAME= ? WHERE ID = ?";
		int impactedRows =jdbcTempate.update(sql, formateur.getPrenom(), formateur.getNom(), formateur.getId());

		return (impactedRows==0)?null:formateur;
	}

	@Override
	public void delete(Formateur formateur) {

		String sql = "DELETE " + TABLE_NAME_FORMATEUR + " WHERE ID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", formateur.getId());
		int impactedRows = namedJdbcTemplate.update(sql, /* params */ Map.of("id", formateur.getId()));


	}

	@Override
	public void deleteById(Long id) {
		String sql = "DELETE " + TABLE_NAME_FORMATEUR + " WHERE ID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		int impactedRows = namedJdbcTemplate.update(sql, /* params */ Map.of("id", id));

	}

	@Override
	public Optional<Formateur> findById(Long id) {

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
		return Optional.ofNullable(formateur);
	}

	@Override
	public List<Formateur> findAll() {

		List<Formateur> formateurs = new ArrayList<>();
		String sql = " SELECT * FROM " + TABLE_NAME_FORMATEUR;
		List<Map<String, Object>> result = this.jdbcTempate.queryForList(sql);

		for (Map<String, Object> ligne : result) {
			Formateur formateur = new Formateur();
			formateur.setId((Long) ligne.get("ID"));
			formateur.setNom((String) ligne.get("LAST_NAME"));
			formateur.setPrenom((String) ligne.get("FIRST_NAME"));

			formateurs.add(formateur);

		}

		return formateurs;
	}

	public List<Formateur> findAll2() {

		String sql = " SELECT * FROM " + TABLE_NAME_FORMATEUR;
		List<Formateur> formateurs = this.jdbcTempate.query(sql, new FormateurMapper());
		return formateurs;
	}

	@Override
	public FormateurDTO findByDiscipline(FormateurDTO formateurDto) {
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
				dto.setEntity(formateur);
				dto.setFormations(formations);

				return dto;

			}

		};

		String sql = "SELECT t.id as id_formateur, f.id as id_formation, t.*,f.* FROM " + TABLE_NAME_FORMATEUR + " t "
				+ "inner join " + TABLE_NAME_FORMATION + " f  on f.id_formateur = t.id" + " WHERE t.ID = ?";
		return jdbcTempate.query(sql, new Object[] { 1L }, formateurFormationExtractor);

	}

}
