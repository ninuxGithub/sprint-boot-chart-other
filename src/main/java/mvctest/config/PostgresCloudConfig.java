package mvctest.config;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("cloud")
@Configuration
public class PostgresCloudConfig extends AbstractCloudConfig {
	
	private static final String url ="jdbc:mysql://localhost:3306/test";
	private static final String username ="root";
	private static final String password ="root";
	

//	 @Bean
//	 public DataSource dataSource() {
//	 return connectionFactory().dataSource();
//	 }

	
	

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource dataSource = new DriverManagerDataSource(url, username, password);
		System.err.println("数据源是否是null :"+dataSource == null);
		return dataSource;
	}
}
