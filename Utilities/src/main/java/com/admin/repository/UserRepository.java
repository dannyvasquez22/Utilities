package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.repository.CrudRepository;

import com.admin.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
