package com.commerce.pharmacy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.commerce.pharmacy.dto.CreateUserRequest;
import com.commerce.pharmacy.dto.UpdateUserRequest;
import com.commerce.pharmacy.dto.UserDto;
import com.commerce.pharmacy.model.User;
import com.commerce.pharmacy.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id) {

		return ResponseEntity.ok(userService.getUserById(id));

	}

	@GetMapping
	//	@PreAuthorize(value = "hasAnyAuthority('ROLE_USER')")
	public ResponseEntity<List<User>> getAllUsers() {

		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {

		return ResponseEntity.ok(userService.createUser(request));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UpdateUserRequest request, @PathVariable Integer id) {

		return ResponseEntity.ok(userService.updateUser(request, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> activateUser(@PathVariable("id") Integer id) {
		userService.activateUser(id);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{id}/deactivate")
	public ResponseEntity<Void> deactivateUser(@PathVariable("id") Integer id) {
		userService.deactivateUser(id);

		return ResponseEntity.ok().build();
	}

//	@ExceptionHandler
//	public String handleAccessDenaiedExceptions(AccessDeniedException exception){
//
//		return "You don't have an authority to get it";
//	}

}
