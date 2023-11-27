package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Movie;

//Movieテーブル：リポジトリ
public interface MovieRepository extends CrudRepository<Movie,Integer>{
	
}
