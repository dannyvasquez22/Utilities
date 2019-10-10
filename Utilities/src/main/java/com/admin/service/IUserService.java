package com.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.admin.model.User;

public interface IUserService extends ICRUD<User> {

	Page<User> listPage(Pageable pageable);
}
