package com.sample.im.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class IMConfig {

	@Value("classpath:db\\create-db.sql")
	private Resource schemaScript;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSource dataSource()
	{
	    DriverManagerDataSource dm = new DriverManagerDataSource("jdbc:derby:im");
	    Properties properties = new Properties();
	    //properties.setProperty("create", "true");
	    dm.setConnectionProperties(properties);	   
	    dm.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");

	    return dm;
	}

	
	@Bean(name="Application.dataSourceInitializer")
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) 
	{
	    final DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(dataSource);
	    try
	    {
	        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	        jdbc.queryForList("SELECT id FROM table_connection");
	    }
	    catch(Exception e)
	    {
	        initializer.setDatabasePopulator(databasePopulator());
	    }
	    return initializer;
	}
		
	private DatabasePopulator databasePopulator() 
	{
	    final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.setContinueOnError(true);
	    populator.setIgnoreFailedDrops(true);
	    populator.addScript(schemaScript);
	    return populator;
	}
	
}
