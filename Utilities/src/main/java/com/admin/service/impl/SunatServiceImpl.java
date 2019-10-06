package com.admin.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.client.ApiSunat;
import com.admin.client.ScrapSunat;
import com.admin.client.request.ClienteRequest;
import com.admin.client.response.ExchangeRate;
import com.admin.client.response.UserJne;
import com.admin.client.response.UserReniec;
import com.admin.client.response.UserSunat;
import com.admin.service.ISunatService;

@Service
public class SunatServiceImpl implements ISunatService {

	@Autowired
	private ApiSunat apiSunat;
	
	@Autowired
	private ScrapSunat scrapSunat;
	
	public String getClientByApi(ClienteRequest request) {
		return apiSunat.getClientByRuc(request);
	}
	
	public JSONObject getClientByApiJSON(ClienteRequest request) {
		return apiSunat.getClientByRucJSON(request);
	}

	@Override
	public List<ExchangeRate> getExchangeRate(int monthNumber, int year) {
		return scrapSunat.getExchangeRate(monthNumber, year);
	}

	@Override
	public UserJne getUserJne(String numero_documento) {
		return scrapSunat.getUserJne(numero_documento);
	}

	@Override
	public UserReniec getUserReniec(String numero_documento) {
		return scrapSunat.getUserReniec(numero_documento);
	}

	@Override
	public UserSunat getUserSunat(String numero_documento) {
		return scrapSunat.getUserSunat(numero_documento);
	}
}
