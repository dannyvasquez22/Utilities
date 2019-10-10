package com.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.admin.model.User;
import com.admin.repository.UserRepository;
import com.admin.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository user;
	
	@Override
	public User save(User t) {
		return user.save(t);
	}

	@Override
	public User update(User t) {
		return user.save(t);
	}

	@Override
	public void delete(int id) {
		user.deleteById(id);
	}

	@Override
	public User getById(int id) {
		Optional<User> userOptional = user.findById(id);
		
//		if (!userOptional.isPresent()) return null;
		
		return userOptional.orElse(null);
	}

	@Override
	public List<User> getAll() {
		return user.findAll();
	}

	@Override
	public Page<User> listPage(Pageable pageable) {
		return user.findAll(pageable);
	}	
}
