package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/welcome")
	public String welcome_S() {
		return "Hello World";
	}
	
	@GetMapping(path = "/welcome-i18n")
	public String welcome_International() {
		return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
	}
}
