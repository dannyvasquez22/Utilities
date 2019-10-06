package com.admin.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.client.request.ClienteRequest;
import com.admin.client.response.ExchangeRate;
import com.admin.client.response.UserJne;
import com.admin.client.response.UserReniec;
import com.admin.client.response.UserSunat;
import com.admin.service.ISunatService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sunat")
@Slf4j
public class SunatController {
	
	@Autowired
	private ISunatService sunatService;

	@GetMapping(value = "/api/{ruc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getClientFromSunat(@PathVariable("ruc") String ruc) {
		log.info("Getting client");
		return new ResponseEntity<String>(sunatService.getClientByApi(new ClienteRequest(ruc)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/api_json/{ruc}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject>  getClientFromSunatJSON(@PathVariable("ruc") String ruc) {
		log.info("Getting client_json");
		return new ResponseEntity<JSONObject>(sunatService.getClientByApiJSON(new ClienteRequest(ruc)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/exchange_rate/{month}-{year}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ExchangeRate>>  getExchangeRate(@PathVariable("month") int month, @PathVariable("year") int year) {
		log.info("Getting exchange_rate");
		return new ResponseEntity<List<ExchangeRate>>(sunatService.getExchangeRate(month, year), HttpStatus.OK);
	}
	
	@GetMapping(value = "/jne/{numero_documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserJne>  getUserJne(@PathVariable("numero_documento") String numero_documento) {
		log.info("Getting exchange_rate");
		return new ResponseEntity<UserJne>(sunatService.getUserJne(numero_documento), HttpStatus.OK);
	}
	
	@GetMapping(value = "/reniec/{numero_documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserReniec>  getUserReniec(@PathVariable("numero_documento") String numero_documento) {
		log.info("Getting exchange_rate");
		return new ResponseEntity<UserReniec>(sunatService.getUserReniec(numero_documento), HttpStatus.OK);
	}
	
	@GetMapping(value = "/sunat/{numero_documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserSunat>  getUserSunat(@PathVariable("numero_documento") String numero_documento) {
		log.info("Getting exchange_rate");
		return new ResponseEntity<UserSunat>(sunatService.getUserSunat(numero_documento), HttpStatus.OK);
	}
}
