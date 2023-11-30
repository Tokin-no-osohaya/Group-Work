package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LoginUser;

public interface UserRepository extends JpaRepository<LoginUser, Long> {
   Optional<LoginUser> findByUsername(String username);
}