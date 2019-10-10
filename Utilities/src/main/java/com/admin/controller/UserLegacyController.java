package com.admin.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.admin.exception.ModeloNotFoundException;
import com.admin.model.legacy.UserLegacy;
import com.admin.service.IUserLegacyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/usersLegacys")
@Slf4j
@Api(value = "Servicio REST para los usuarios antiguos.")
public class UserLegacyController {

	@Autowired
	private IUserLegacyService userLegacyService;
	
	@ApiOperation("Retorna una lista de usuarios antiguos.")
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserLegacy>> getAll() {
		log.info("Getting userLegay");
		return new ResponseEntity<List<UserLegacy>>(userLegacyService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<UserLegacy>> listarPageable(Pageable pageable){
		Page<UserLegacy> users;
		users = userLegacyService.listPage(pageable);
		return new ResponseEntity<Page<UserLegacy>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<UserLegacy> getById(@PathVariable("id") Integer id) {
		UserLegacy user = userLegacyService.getById(id);
		
		if (user == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		Resource<UserLegacy> resource = new Resource<UserLegacy>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getById(id));
		resource.add(linkTo.withRel("User-resource"));
		
		return resource;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserLegacy> save(@Valid @RequestBody UserLegacy User) {
		UserLegacy userSave = new UserLegacy();
		userSave = userLegacyService.save(User);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSave.getId()).toUri();
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		
//		return ResponseEntity.created(location).build();
		return new ResponseEntity<UserLegacy>(userSave, responseHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody UserLegacy User) {
		userLegacyService.update(User);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		UserLegacy User = userLegacyService.getById(id);
		
		if (User == null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			userLegacyService.delete(id);
		}
	}
}
