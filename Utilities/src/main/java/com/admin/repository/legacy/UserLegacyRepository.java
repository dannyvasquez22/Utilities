package com.admin.repository.legacy;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.repository.CrudRepository;

import com.admin.model.legacy.UserLegacy;

public interface UserLegacyRepository extends JpaRepository<UserLegacy, Integer> {

}
