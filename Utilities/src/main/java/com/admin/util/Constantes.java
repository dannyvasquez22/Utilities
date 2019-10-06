package com.admin.util;

public class Constantes {
	
	public static final String S_UNO = "1";

	public static final String S_MONTH_EXCHANGE_RATE = "MONTH";
	public static final String S_YEAR_EXCHANGE_RATE = "YEAR";
	public static final String S_NUMBER_DOCUMENT = "SEARCH_DOCUMENT";
	
	public static final String S_HIBERNATE_SHOWSQL = "hibernate.show-sql";
	public static final String S_HIBERNATE_DIALECT = "hibernate.dialect";
	
	public static final String S_SUNAT_PARAM1 = "accion";
	public static final String S_SUNAT_VALUE1 = "consPorRuc";
	public static final String S_SUNAT_PARAM2 = "nroRuc";
	public static final String S_SUNAT_PARAM3 = "actReturn";
	public static final String S_SUNAT_PARAM4 = "numRnd";

	public static final String S_PROP_APISUNAT_URL = "${api.sunat.url}";
	public static final String S_PROP_APISUNAT_READTIMEOUT = "${api.sunat.read.timeout}";
	public static final String S_PROP_APISUNAT_CONNECTIONTIMEOUT = "${api.sunat,connection.timeout}";
	
	public static final String S_PROP_EXCHANGERATE_URL = "${exchange_rage_url}";
	public static final String S_PROP_CAPTCHA_URL = "${captcha_url}";
	public static final String S_PROP_JNE_URL = "${jne_url}";
	public static final String S_PROP_RENIEC_URL = "${reniec_url}";
	public static final String S_PROP_SUNATCAPTCHA_URL = "${sunat_captcha_url}";
	public static final String S_PROP_SUNAT_URL = "${sunat_url}";
	
	//DATABASE 1
	public static final String S_HIBERNATE_DB1_EMFACTORY = "uEntityManagerFactory";
	public static final String S_HIBERNATE_DB1_EMTRANSACTION = "uTransactionManager";
	public static final String S_HIBERNATE_DB1_PKGREPOSITORY = "com.admin.repository";
	public static final String S_HIBERNATE_DB1_DS = "uDataSource";
	public static final String S_HIBERNATE_DB1_PKGMODEL = "com.admin.model";
	
	public static final String S_PROP_DB1_URL = "${spring.datasource.url}";
	public static final String S_PROP_DB1_USER = "${spring.datasource.username}";
	public static final String S_PROP_DB1_PASS = "${spring.datasource.password}";
	public static final String S_PROP_DB1_DRIVER = "${spring.datasource.driverClassName}";
	public static final String S_PROP_DB1_SHOWSQL = "${spring.jpa.show-sql}";
	public static final String S_PROP_DB1_PLATFORM = "${spring.jpa.database-platform}";
	
	//DATABASE 2
	public static final String S_HIBERNATE_DB2_EMFACTORY = "userLegacyEntityManagerFactory";
	public static final String S_HIBERNATE_DB2_EMTRANSACTION = "userLegacyTransactionManager";
	public static final String S_HIBERNATE_DB2_PKGREPOSITORY = "com.admin.repository.legacy";
	public static final String S_HIBERNATE_DB2_DS = "userLegacyDataSource";
	public static final String S_HIBERNATE_DB2_PKGMODEL = "com.admin.model.legacy";
	
	public static final String S_PROP_DB2_URL = "${d2.datasource.url}";
	public static final String S_PROP_DB2_USER = "${d2.datasource.username}";
	public static final String S_PROP_DB2_PASS = "${d2.datasource.password}";
	public static final String S_PROP_DB2_DRIVER = "${d2.datasource.driverClassName}";
	public static final String S_PROP_DB2_SHOWSQL = "${d2.jpa.show-sql}";
	public static final String S_PROP_DB2_PLATFORM = "${d2.jpa.database-platform}";
}
