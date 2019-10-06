package com.admin.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {

	@Value(Constantes.S_PROP_APISUNAT_URL)
	public String APISUNAT_URL;
	
	@Value(Constantes.S_PROP_APISUNAT_READTIMEOUT)
	public int APISUNAT_READTIMEOUT;
			
	@Value(Constantes.S_PROP_APISUNAT_CONNECTIONTIMEOUT)
	public int APISUNAT_CONNECTIONTIMEOUT;
	
	@Value(Constantes.S_PROP_EXCHANGERATE_URL)
	public String EXCHANGERATE_URL;
	
	@Value(Constantes.S_PROP_CAPTCHA_URL)
	public String CAPTCHA_URL;
	
	@Value(Constantes.S_PROP_JNE_URL)
	public String JNE_URL;
	
	@Value(Constantes.S_PROP_RENIEC_URL)
	public String RENIEC_URL;
	
	@Value(Constantes.S_PROP_SUNATCAPTCHA_URL)
	public String SUNATCAPTCHA_URL;
	
	@Value(Constantes.S_PROP_SUNAT_URL)
	public String SUNAT_URL;
	
	
	@Value(Constantes.S_PROP_DB1_URL)
	public String DB1_URL;
	
	@Value(Constantes.S_PROP_DB1_USER)
	public String DB1_USER;
	
	@Value(Constantes.S_PROP_DB1_PASS)
	public String DB1_PASS;
	
	@Value(Constantes.S_PROP_DB1_DRIVER)
	public String DB1_DRIVER;
	
	@Value(Constantes.S_PROP_DB1_SHOWSQL)
	public String DB1_SHOWSQL;
	
	@Value(Constantes.S_PROP_DB1_PLATFORM)
	public String DB1_PLATFORM;
	
	
	@Value(Constantes.S_PROP_DB2_URL)
	public String DB2_URL;
	
	@Value(Constantes.S_PROP_DB2_USER)
	public String DB2_USER;
	
	@Value(Constantes.S_PROP_DB2_PASS)
	public String DB2_PASS;
	
	@Value(Constantes.S_PROP_DB2_DRIVER)
	public String DB2_DRIVER;
	
	@Value(Constantes.S_PROP_DB2_SHOWSQL)
	public String DB2_SHOWSQL;
	
	@Value(Constantes.S_PROP_DB2_PLATFORM)
	public String DB2_PLATFORM;
}
