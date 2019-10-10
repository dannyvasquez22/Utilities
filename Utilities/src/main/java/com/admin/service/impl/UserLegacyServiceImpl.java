package com.admin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.admin.model.legacy.UserLegacy;
import com.admin.repository.legacy.UserLegacyRepository;
import com.admin.service.IUserLegacyService;

@Service
public class UserLegacyServiceImpl implements IUserLegacyService {

	@Autowired
	private UserLegacyRepository user;

	@Override
	public UserLegacy save(UserLegacy t) {
		return user.save(t);
	}

	@Override
	public UserLegacy update(UserLegacy t) {
		return user.save(t);
	}

	@Override
	public void delete(int id) {
		user.deleteById(id);
	}

	@Override
	public UserLegacy getById(int id) {
		Optional<UserLegacy> userOptional = user.findById(id);
		
		if (!userOptional.isPresent()) return null;
		
		return userOptional.get();
	}

	@Override
	public List<UserLegacy> getAll() {
		return user.findAll();
	}

	@Override
	public Page<UserLegacy> listPage(Pageable pageable) {
		return user.findAll(pageable);
	}
}
