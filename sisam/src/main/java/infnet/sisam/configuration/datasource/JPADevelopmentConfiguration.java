package infnet.sisam.configuration.datasource;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import infnet.sisam.helper.Constantes;
import infnet.sisam.helper.UrlProvider;

@Profile("dev")
public class JPADevelopmentConfiguration {

	@Bean
	public Properties aditionalProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		props.put("hibernate.hbm2ddl.auto", "update");

		return props;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("ms1002");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sisam");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		return dataSource;
	}
	
	@Bean
	public UrlProvider urlProvider() {
		UrlProvider provider = new UrlProvider();
		provider.setUrl(Constantes.URI_SERVER_DEV);
		return provider;
	}

}
