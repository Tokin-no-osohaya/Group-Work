package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.LoginUser;

public interface UserService {
    Optional<LoginUser> getUserByUsername(String username);
	void saveUser(LoginUser newUser);
}
