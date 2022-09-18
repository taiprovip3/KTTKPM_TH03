package com.example.spring_boot_api_jwt.service;

import com.example.spring_boot_api_jwt.authen.UserPrincipal;
import com.example.spring_boot_api_jwt.entity.User;

public interface UserService {//Chi chua cac service
	public User createUser(User user);	//Ham nay tao user
    public UserPrincipal findUserByUsername(String username);	//Ham nay tra ve 1 object: UserPrincipal
}
