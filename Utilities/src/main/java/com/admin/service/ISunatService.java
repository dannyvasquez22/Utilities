package com.admin.service;

import java.util.List;

import org.json.JSONObject;

import com.admin.client.request.ClienteRequest;
import com.admin.client.response.ExchangeRate;
import com.admin.client.response.UserJne;
import com.admin.client.response.UserReniec;
import com.admin.client.response.UserSunat;

public interface ISunatService {

	public String getClientByApi(ClienteRequest request);	
	public JSONObject getClientByApiJSON(ClienteRequest request);
	
	public List<ExchangeRate> getExchangeRate(int monthNumber, int year);
	
	public UserJne getUserJne(String numero_documento);
	public UserReniec getUserReniec(String numero_documento);
	public UserSunat getUserSunat(String numero_documento);
}
