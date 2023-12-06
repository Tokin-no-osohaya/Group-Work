package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Movie;

//Movieテーブル：リポジトリ
public interface MovieRepository extends JpaRepository<Movie,Integer>{
	
}
