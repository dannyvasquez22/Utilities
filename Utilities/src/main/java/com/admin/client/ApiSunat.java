package com.admin.client;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.admin.client.request.ClienteRequest;
import com.admin.util.PropertiesConfig;
import com.google.gson.Gson;

@Component
public class ApiSunat {

	@Autowired
	private PropertiesConfig properties;
	
	public String getClientByRuc(ClienteRequest request) {
		HttpComponentsClientHttpRequestFactory clientRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientRequestFactory.setReadTimeout(properties.APISUNAT_READTIMEOUT);
		clientRequestFactory.setConnectTimeout(properties.APISUNAT_CONNECTIONTIMEOUT);
		
		RestTemplate restTemplate = new RestTemplate(clientRequestFactory);
		
		// https://api.sunat.cloud/buscar/RAZON_SOCIAL
		String obj = restTemplate.getForObject(properties.APISUNAT_URL + request.getRuc(), String.class);

		Gson g = new Gson();
		g.toJson(obj);
		
		return g.toJson(obj);
	}
	
	public JSONObject getClientByRucJSON(ClienteRequest request) {
		HttpComponentsClientHttpRequestFactory clientRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientRequestFactory.setReadTimeout(properties.APISUNAT_READTIMEOUT);
		clientRequestFactory.setConnectTimeout(properties.APISUNAT_CONNECTIONTIMEOUT);
		
		RestTemplate restTemplate = new RestTemplate(clientRequestFactory);
		// https://api.sunat.cloud/buscar/RAZON_SOCIAL
		
		System.out.println(restTemplate.getForObject(properties.APISUNAT_URL + request.getRuc(), Object.class));
		
		return restTemplate.getForObject(properties.APISUNAT_URL + request.getRuc(), JSONObject.class);
	}
}
