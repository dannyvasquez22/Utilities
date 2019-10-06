package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.User;
import com.admin.model.legacy.UserLegacy;
import com.admin.repository.UserRepository;
import com.admin.repository.legacy.UserLegacyRepository;
import com.admin.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserLegacyRepository userLegacyRepository;
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public List<UserLegacy> getLegacyUsers() {
		return userLegacyRepository.findAll();
	}
	
}
