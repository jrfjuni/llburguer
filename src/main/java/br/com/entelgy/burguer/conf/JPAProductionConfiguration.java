package br.com.entelgy.burguer.conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("prod")
public class JPAProductionConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public Properties additionalProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "PostgreSQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Bean
	public DataSource dataSource() throws URISyntaxException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		
		//user:password@host:port/path
		URI dbUri = new URI(getEnvironment().getProperty("DATABASE_URL"));
		
			StringBuilder url = new StringBuilder("jdbc:postgresql://");
			url.append(dbUri.getHost())
			.append(":")
			.append(dbUri.getPort())
			.append(dbUri.getPath());
		
		dataSource.setUrl(url.toString());
		dataSource.setUsername(dbUri.getUserInfo().split(":")[0]);
		dataSource.setPassword(dbUri.getUserInfo().split(":")[1]);
		
		return dataSource; 
	}
	
	private Environment getEnvironment() {
		return environment;
	}
}
