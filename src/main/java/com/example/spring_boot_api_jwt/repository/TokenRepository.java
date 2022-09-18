package com.example.spring_boot_api_jwt.repository;

import com.example.spring_boot_api_jwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
}
