package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {
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
	public String showall() {
		//戻り値は「ビュー名」を返す
		return "all";
	}

//リンク処理
@GetMapping("/function/{no}")
public String selectFunction(@PathVariable Integer no) {
	//「ビュー名」の初期化
	String show = null;
	switch(no) {
	case 1:
		show = "welcome/function1";
		break;
	case 2:
		show = "welcome/function2";
		break;
	case 3:
		show = "welcome/function3";
		break;
	case 4:
		show = "welcome/function4";
		break;
	case 5:
		show = "welcome/function5";
		break;
	case 6:
		show = "welcome/function6";
		break;
	}
	//戻り値は「ビュー名」を返す
	return show;
	}

//ボタン「予約」押下処理
@PostMapping(value="send",params="a")
	public String showAView() {
		//戻り値は「ビュー名」を返す
		return "submit/a";
	}
}
