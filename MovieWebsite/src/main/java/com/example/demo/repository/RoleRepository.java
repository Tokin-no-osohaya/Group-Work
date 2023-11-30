package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.RoleId;

public interface RoleRepository extends CrudRepository<RoleId, Integer> {
}

