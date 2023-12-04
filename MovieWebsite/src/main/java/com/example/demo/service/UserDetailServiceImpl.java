package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.userdetails.UserDetailsImpl;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository loginUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// login_user テーブルから username に対応するデータを取得する
		Optional<LoginUser> loginUserOpt = loginUserRepository.findByUsername(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		return new UserDetailsImpl(loginUserOpt.get(), authorities);
	}
}