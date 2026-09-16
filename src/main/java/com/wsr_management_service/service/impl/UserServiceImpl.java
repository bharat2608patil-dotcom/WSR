package com.wsr_management_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wsr_management_service.entity.User;
import com.wsr_management_service.exception.ResourceNotFoundException;
import com.wsr_management_service.exception.UserAlreadyPresent;
import com.wsr_management_service.repository.UserRepository;
import com.wsr_management_service.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User save(User user) {

		userRepository.findByEmail(user.getEmail()).ifPresent(u -> {
			throw new UserAlreadyPresent("User already exists with email: " + user.getEmail());
		});

		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
	}
}



