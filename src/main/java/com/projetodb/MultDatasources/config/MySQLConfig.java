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
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "mysqlEntityManagerFactory", 
		basePackages = {"com.projetodb.MultDatasources.repository.mysql" }, 
		transactionManagerRef = "mysqlTransactionManager")
public class MySQLConfig {

	@Autowired
	private Environment env;
	@Autowired
	private DataSourceProperties dsp; 
	
	@Primary
	@Bean("mysqlDataSourceProperties")
	@ConfigurationProperties("mysql.datasource")
	public DataSourceProperties dataSourceProperties() {
		dsp.setUsername(env.getProperty("spring.datasource.username"));
		dsp.setPassword(env.getProperty("spring.datasource.password"));
		dsp.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		return dsp;
	}

	@Primary
	@Bean(name = "mysqlDataSource")
	public DataSource dataSource() {
		return dataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Primary
	@Bean(name = "mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean EntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("mysqlDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.projetodb.MultDatasources.entity.mysql")
				.persistenceUnit("mysql")
				.build();
	}

	@Primary
	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager  TransactionManager(
			@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory  entityManagerFactory) {
		return new JpaTransactionManager( entityManagerFactory);
	}

}
