package com.admin.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(entityManagerFactoryRef = Constantes.S_HIBERNATE_DB2_EMFACTORY, transactionManagerRef = Constantes.S_HIBERNATE_DB2_EMTRANSACTION, basePackages = {
		Constantes.S_HIBERNATE_DB2_PKGREPOSITORY })
public class Database2Config {

	@Autowired
	private PropertiesConfig properties;

	@Bean(name = Constantes.S_HIBERNATE_DB2_DS)
	public DataSource userLegacyDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(properties.DB2_URL);
		dataSource.setUsername(properties.DB2_USER);
		dataSource.setPassword(properties.DB2_PASS);
		dataSource.setDriverClassName(properties.DB2_DRIVER);

		return dataSource;
	}

	@Bean(name = Constantes.S_HIBERNATE_DB2_EMFACTORY)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(userLegacyDatasource());
		em.setPackagesToScan(Constantes.S_HIBERNATE_DB2_PKGMODEL);

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Map<String, Object> propertiesMap = new HashMap<>();
		propertiesMap.put(Constantes.S_HIBERNATE_SHOWSQL, properties.DB2_SHOWSQL);
		propertiesMap.put(Constantes.S_HIBERNATE_DIALECT, properties.DB2_PLATFORM);

		em.setJpaPropertyMap(propertiesMap);

		return em;

	}

	@Bean(name = Constantes.S_HIBERNATE_DB2_EMTRANSACTION)
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}
}
