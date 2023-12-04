package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Movie;

public interface MovieService {
	//全件取得
	Iterable<Movie> selectAll();
	//idをキーに1件取得
	Optional<Movie> selectOneById(Integer id);
}
