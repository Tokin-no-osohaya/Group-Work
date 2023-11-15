package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {
	//画面を表示する
	@GetMapping("show")
	public String showView() {
		//戻り値は「ビュー名」を返す
		return "show";
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
