package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Movie;

//Movieテーブル：リポジトリ
public interface MovieCrudRepository extends CrudRepository<Movie,Integer>{
	
}
