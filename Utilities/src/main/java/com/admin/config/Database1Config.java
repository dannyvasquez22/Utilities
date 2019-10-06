package com.admin.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.admin.util.Constantes;
import com.admin.util.PropertiesConfig;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = Constantes.S_HIBERNATE_DB1_EMFACTORY, transactionManagerRef = Constantes.S_HIBERNATE_DB1_EMTRANSACTION, basePackages = {
	Constantes.S_HIBERNATE_DB1_PKGREPOSITORY
})
public class Database1Config {
	
	@Autowired
	private PropertiesConfig properties;
	
	@Primary
	@Bean(name = Constantes.S_HIBERNATE_DB1_DS)
	public DataSource uDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();		
		dataSource.setUrl(properties.DB1_URL);
		dataSource.setUsername(properties.DB1_USER);
		dataSource.setPassword(properties.DB1_PASS);
		dataSource.setDriverClassName(properties.DB1_DRIVER);
		
		return dataSource;
	}
	

	@Primary
	@Bean(name = Constantes.S_HIBERNATE_DB1_EMFACTORY)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(uDataSource());
		em.setPackagesToScan(Constantes.S_HIBERNATE_DB1_PKGMODEL);
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> propertiesMap = new HashMap<>();
		propertiesMap.put(Constantes.S_HIBERNATE_SHOWSQL, properties.DB1_SHOWSQL);
		propertiesMap.put(Constantes.S_HIBERNATE_DIALECT, properties.DB1_PLATFORM);
		
		em.setJpaPropertyMap(propertiesMap);
		
		return em;
		
	}
	
	@Primary
	@Bean(name = Constantes.S_HIBERNATE_DB1_EMTRANSACTION)
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}
