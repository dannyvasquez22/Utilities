package com.admin.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.admin.model.User;
import com.admin.model.legacy.UserLegacy;
import com.admin.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers() {
		log.info("Getting user");
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/legacyList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserLegacy>> getLegacyUsers() {
		log.info("Getting userLegay");
		return new ResponseEntity<List<UserLegacy>>(userService.getLegacyUsers(), HttpStatus.OK);
	}
	
}