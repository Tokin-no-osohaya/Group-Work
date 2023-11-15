package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.MovieCrudRepository;

@SpringBootApplication
public class MovieWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieWebsiteApplication.class, args);
	}
	@Autowired
	MovieCrudRepository repository;
	
	//idに合致した作品のみを取得
	private void executeSelect() {
		//リポジトリを取得して結果を表示
		//Iterable<Movie> movie = repository.findById(id);
		
	}
}
