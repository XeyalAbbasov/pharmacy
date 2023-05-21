package com.commerce.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.pharmacy.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
