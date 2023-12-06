package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping("show")
	public String showView() {
		//戻り値は「ビュー名」を返す
		return "index";
	}
	
	//一覧画面を表示する
	@GetMapping("view")
	public String showAll(Model model) {
		Iterable<Movie> movies = movieService.selectAll();
		model.addAttribute("movies",movies);
		return "all";
	}

	//リンク画面
	@GetMapping("function/{no}")
	public String selectFunction(@PathVariable Integer no,Model model) {
		//「ビュー名」の初期化
		model.addAttribute("movie",movieService.selectOneById(no).get());
		//戻り値は「ビュー名」を返す
		return "introduction";
	}
	
	//単体ページ
	@GetMapping("")
	

//ボタン「予約」押下処理
@PostMapping(value="send",params="a")
	public String showAView() {
		//戻り値は「ビュー名」を返す
		return "submit/a";
	}
}
