package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Servicio REST de prueba i18n.")
public class InternationalController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/welcome")
	@ApiOperation("Retorna un string.")
	public String welcome_S() {
		return "Hello World";
	}
	
	@GetMapping(path = "/welcome-i18n")
	@ApiOperation("Retorna mensaje de properties dado el idioma que se esta usando.")
	public String welcome_International() {
		return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
	}
}
