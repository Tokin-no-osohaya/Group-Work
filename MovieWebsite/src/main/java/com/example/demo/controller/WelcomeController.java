package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;

@Controller
//@RequsetMapping(/"welcome")
public class WelcomeController {
	@Autowired
	MovieService movieService;
	
	//スプラッシュスクリーンを表示する
	@GetMapping("first")
	public String showSplash() {
		return "splash";
	}
	
	//トップ画面を表示する
	@GetMapping("show/{username}")
	public String showView(@PathVariable String username,Model model) {
		model.addAttribute("movie",movieService.selectOneById(6).get());
		model.addAttribute("username",username);
		//戻り値は「ビュー名」を返す
		return "index";
	}
	
	//一覧画面を表示する
	@GetMapping("view/{username}")
	public String showAll(@PathVariable String username,Model model) {
		Iterable<Movie> movies = movieService.selectAll();
		model.addAttribute("movies",movies);
		model.addAttribute("username",username);
		return "all";
	}

	//リンク画面
	@GetMapping("view/function/{username}/{no}")
	public String selectFunction(@PathVariable String username,@PathVariable Integer no,Model model) {
		//「ビュー名」の初期化
		model.addAttribute("movie",movieService.selectOneById(no).get());
		model.addAttribute("username",username);
		//戻り値は「ビュー名」を返す
		return "introduction";
	}
	
}
