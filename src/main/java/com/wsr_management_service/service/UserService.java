package com.wsr_management_service.service;

import java.util.List;
import java.util.Optional;

import com.wsr_management_service.entity.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User findById(Long id);

}