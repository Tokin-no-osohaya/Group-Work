package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // login.htmlを返す
    }
    @GetMapping(value="/login", params="error")
	public String loginFail(Model model) {
	model.addAttribute("errorMessage", "ログインに失敗しました");
	// ログイン画面を表示
	return "login";
}
}

