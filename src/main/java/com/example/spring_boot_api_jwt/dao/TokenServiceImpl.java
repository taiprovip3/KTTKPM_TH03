package com.example.spring_boot_api_jwt.dao;

import com.example.spring_boot_api_jwt.entity.Token;
import com.example.spring_boot_api_jwt.repository.TokenRepository;
import com.example.spring_boot_api_jwt.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }
}

