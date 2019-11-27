package com.projetodb.MultDatasources.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "postgresqlEntityManagerFactory", 
		basePackages = {"com.projetodb.MultDatasources.repository.postgresql" }, 
		transactionManagerRef = "postgresqlTransactionManager")
public class PostgresqlConfig {

	@Autowired
	private Environment env;
	
	
	
	@Bean("postgresqlDataSourceProperties")
	@ConfigurationProperties("postgresql.datasource")
	public DataSourceProperties dataSourceProperties() {
		DataSourceProperties dsp = new  DataSourceProperties(); 
		dsp.setUsername(env.getProperty("postgresql.datasource.username"));
		dsp.setPassword(env.getProperty("postgresql.datasource.password"));
		dsp.setDriverClassName(env.getProperty("postgresql.datasource.driver-class-name"));
		return dsp;
	}

	
	@Bean(name = "postgresqlDataSource")
	public DataSource dataSource() {
		return dataSourceProperties().initializeDataSourceBuilder().build();
	}

	
	@Bean(name = "postgresqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresqlDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.projetodb.MultDatasources.entity.postgresql")
				.persistenceUnit("postgresql")
				.build();
	}

	
	@Bean(name = "postgresqlTransactionManager")
	public PlatformTransactionManager  TransactionManager(
			@Qualifier("postgresqlEntityManagerFactory") EntityManagerFactory  entityManagerFactory) {
		return new JpaTransactionManager( entityManagerFactory);
	}

}
