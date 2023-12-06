package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class ServiceImpl implements MovieService {
	//Repository注入
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public Iterable<Movie> selectAll() {
		return movieRepository.findAll();
	}
	
	@Override
	public Optional<Movie> selectOneById(Integer id) {
		return movieRepository.findById(id.toString());
	}

}
