package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;

@SpringBootApplication
public class MovieWebsiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieWebsiteApplication.class, args)
		.getBean(MovieWebsiteApplication.class).execute();
	}
	@Autowired
	MovieRepository repository;
	
	//実行メソッド
	private void execute() {
		//全件表示
		//showList();
	}
	
	//全件取得
	private void showList(){
		//リポジトリを使用して1件を表示（戻り値はOptional）
		Iterable<Movie> movies = repository.findAll();
		for(Movie movie : movies) {
			
		}
	}
}
