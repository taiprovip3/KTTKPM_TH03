package com.example.spring_boot_api_jwt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_api_jwt.authen.UserPrincipal;
import com.example.spring_boot_api_jwt.entity.User;
import com.example.spring_boot_api_jwt.repository.UserRepository;
import com.example.spring_boot_api_jwt.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

	@Transactional
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

	@Transactional
    public UserPrincipal findUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();

        if (null != user) {
            Set<String> authorities = new HashSet<>();
            if (null != user.getRoles())

                user.getRoles().forEach(r -> {
                authorities.add(r.getRoleKey());
                r.getPermissions().forEach(
                        p -> authorities.add(p.getPermissionKey()));
            });

            userPrincipal.setUserId(user.getUserId());
            userPrincipal.setUsername(user.getUsername());
            userPrincipal.setPassword(user.getPassword());
            userPrincipal.setAuthorities(authorities);
        }

        return userPrincipal;
    }
}
