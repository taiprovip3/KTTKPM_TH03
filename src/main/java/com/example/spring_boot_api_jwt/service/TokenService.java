package com.example.spring_boot_api_jwt.service;

import com.example.spring_boot_api_jwt.entity.Token;

public interface TokenService {
    public Token createToken(Token token);
}
