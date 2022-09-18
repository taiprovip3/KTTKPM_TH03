package com.example.spring_boot_api_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_api_jwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findUserByUsername(String username);
}
