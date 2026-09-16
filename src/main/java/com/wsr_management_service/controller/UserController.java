package com.wsr_management_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsr_management_service.dto.ApiResponse;
import com.wsr_management_service.entity.User;
import com.wsr_management_service.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<ApiResponse<User>> saveUser(@Valid @RequestBody User user) {

		User savedUser = userService.save(user);

		return ResponseEntity.ok(
				ApiResponse.<User>builder().success(true).message("User Created Successfully").data(savedUser).build());
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {

		return userService.findById(id);
	}
}