package com.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.admin.model.legacy.UserLegacy;

public interface IUserLegacyService extends ICRUD<UserLegacy> {

	Page<UserLegacy> listPage(Pageable pageable);
}
