package com.admin.service;

import java.util.List;

import com.admin.model.User;
import com.admin.model.legacy.UserLegacy;

public interface IUserService {

	public List<User> getUsers();	
	public List<UserLegacy> getLegacyUsers();
}
