package com.mc.gestionformation.business;

import static org.junit.Assert.assertNotNull;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.annotation.Transactional;

import com.mc.gestionformation.dto.FormateurDTO;
import com.mc.gestionformation.integration.dao.jdbctemplate.FormateurDAOJdbcTemplate;
import com.mc.gestionformation.integration.dao.jdbctemplate.FormationDAOJdbcTemplate;
import com.mc.gestionformation.model.Formateur;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormationBusinessTest {

	@Autowired
	IFormationService formationBusines;

	@Autowired
	FormateurBusiness formateurBusines;

	@Autowired
	FormateurDAOJdbcTemplate formateurDao;

	@Autowired
	FormationDAOJdbcTemplate formationDao;

//	@Test
//	// @Commit
//	@Order(1)
//	public void _1_createFormationEtFormateurTestPositive() {
//
//		FormationDTO formationDto = new FormationDTO();
//
//		Formateur formateur = new Formateur();
//		formateur.setId(5L);
//		formateur.setNom("Test Nom");
//		formateur.setPrenom("Test Prenom");
//		formationDto.setFormateur(formateur);
//
//		Formation formation = new Formation();
//		formation.setId(5L);
//		formation.setCode("Test code");
//		formation.setTitre("Test Titre");
//		formationDto.setFormation(formation);
//
//		FormationDTO formationDtoResult = formationBusines.enregistrer(formationDto);
//
//		assertNotNull(formationDtoResult);
//		assertNotNull(formation = formationDtoResult.getFormation());
//
//	}

	@Test
	// @Commit
	@Order(1)
	@Transactional
	public void _1_createFormateurTestPositive() {

		FormateurDTO formationDto = new FormateurDTO();

		Formateur formateur = new Formateur();
		formateur.setId(4L);
		formateur.setNom("Test Nom");
		formateur.setPrenom("Test Prenom");
		formationDto.setFormateur(formateur);
		
		//formateurBusines.findById(formationDto);

		FormateurDTO formationDtoResult = formateurBusines.enregistrer(formationDto);
		assertNotNull(formationDtoResult);
		assertNotNull(formationDtoResult.getFormateur());

	}

	@Test
	@Order(2)
	public void _2_finAllTestPositive() {
		long nbrformateur = formateurDao.count();
		long nbrformation = formationDao.count();
		System.out.println("Nombre de fomateur in _2_finAllTestPositive = " + nbrformateur);
		System.out.println("Nombre de formation in _2_finAllTestPositive = " + nbrformation);
	}

	@Configuration
	@ComponentScan(basePackageClasses = { FormationBusiness.class, FormateurBusiness.class,
			FormateurDAOJdbcTemplate.class, FormationDAOJdbcTemplate.class })
	@EnableTransactionManagement(proxyTargetClass = true) // 1 etape pour activation du contexte transactionnnelle
	static class DBconfig implements TransactionManagementConfigurer {

		@Bean
		JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate(dataSource());
		}

	
		@Bean
		NamedParameterJdbcTemplate namedJdbcTemplate() {
			return new NamedParameterJdbcTemplate(dataSource());
		}

		// Création de 1 à plusieurs TransactionManager
		@Bean
		// @Primary
		PlatformTransactionManager transactionManager() {
			return new DataSourceTransactionManager(dataSource());
		}

		@Bean
		PlatformTransactionManager transactionManager2() {
			return new DataSourceTransactionManager(dataSource());
		}

		@Bean
		DataSource dataSource() {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			EmbeddedDatabase ds = builder.setType(EmbeddedDatabaseType.H2).generateUniqueName(true)
					.addScript("classpath:db/jdbctemplate/schema-test-jt.sql")
					.addScript("classpath:db/jdbctemplate/data-test-jt.sql").build();
			DataSource dss = new DataSource() {

				@Override
				public <T> T unwrap(Class<T> iface) throws SQLException {
					return ds.unwrap(iface);
				}

				@Override
				public boolean isWrapperFor(Class<?> iface) throws SQLException {
					// TODO Auto-generated method stub
					return ds.isWrapperFor(iface);
				}

				@Override
				public Logger getParentLogger() throws SQLFeatureNotSupportedException {
					// TODO Auto-generated method stub
					return ds.getParentLogger();
				}

				@Override
				public void setLoginTimeout(int seconds) throws SQLException {
					ds.setLoginTimeout(seconds);

				}

				@Override
				public void setLogWriter(PrintWriter out) throws SQLException {
					ds.setLogWriter(out);
				}

				@Override
				public int getLoginTimeout() throws SQLException {
					// TODO Auto-generated method stub
					return ds.getLoginTimeout();
				}

				@Override
				public PrintWriter getLogWriter() throws SQLException {
					// TODO Auto-generated method stub
					return ds.getLogWriter();
				}

				@Override
				public Connection getConnection(String username, String password) throws SQLException {
					Connection connection = ds.getConnection(username, password);
					connection.setAutoCommit(false);
					return connection;
				}

				@Override
				public Connection getConnection() throws SQLException {
					Connection connection = ds.getConnection();
					connection.setAutoCommit(false);
					return connection;
				}
			};
			return dss;
		}

		@Override
		public TransactionManager annotationDrivenTransactionManager() {
			return transactionManager();
		}

	}

}
