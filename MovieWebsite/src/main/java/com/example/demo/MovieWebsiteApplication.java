package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieCrudRepository;

@SpringBootApplication
public class MovieWebsiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieWebsiteApplication.class, args)
		.getBean(MovieWebsiteApplication.class).execute();
	}
	@Autowired
	MovieCrudRepository repository;
	
	//実行メソッド
	private void execute() {
		//表示
		showOne(1);
	}
	
	//idに合致した作品のみを取得
	private void showOne(Integer id) {
		//リポジトリを使用して1件を表示（戻り値はOptional）
		Optional<Movie> movies = repository.findById(id);
	}
}
