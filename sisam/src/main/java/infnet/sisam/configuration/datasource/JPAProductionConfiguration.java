package infnet.sisam.configuration.datasource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import infnet.sisam.helper.Constantes;
import infnet.sisam.helper.UrlProvider;

@Profile("prod")
public class JPAProductionConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public Properties aditionalProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		props.put("hibernate.hbm2ddl.auto", "update");

		return props;
	}

	@Bean
	public DataSource dataSource() throws URISyntaxException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		URI dbUrl = new URI(environment.getProperty("DATABASE_URL"));
		dataSource.setUrl("jdbc:postgresql://" + dbUrl.getHost() + ":" + dbUrl.getPort() + dbUrl.getPath());
		dataSource.setUsername(dbUrl.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbUrl.getUserInfo().split(":")[1]);
		return dataSource;
	}

	@Bean
	public UrlProvider urlProvider() {
		UrlProvider provider = new UrlProvider();
		provider.setUrl(Constantes.URI_SERVER_PROD);
		return provider;
	}

}
