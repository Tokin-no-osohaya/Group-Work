package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;

@Service
public class ServiceImpl implements MovieService {
	//Repository注入
	@Autowired
	
	@Override
	public Iterable<Movie> selectAll() {
		return null;
	}

	@Override
	public Optional<Movie> selectOneById(Integer id) {
		return Optional.empty();
	}

}
