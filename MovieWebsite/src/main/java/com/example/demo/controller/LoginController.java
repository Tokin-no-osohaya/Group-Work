package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.UserForm;
import com.example.demo.service.userdetails.UserDetailsImpl;

@Controller
public class LoginController {
	@ModelAttribute
	public UserForm addUserForm() {
		return new UserForm();
	}

    @GetMapping("/login")
    public String login() {
        return "login"; // login.htmlを返す
    }
    
    @GetMapping(value="/login", params="error")
	public String loginError(Model model) {
	model.addAttribute("failureMessage", "ログインに失敗しました");
	// ログイン画面を表示
	return "login";
    }
 
    @GetMapping("menu")
	String index(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UserDetailsImpl principal = (UserDetailsImpl)auth.getPrincipal();
    	model.addAttribute("username", principal.getUsername());
		return "menu";//menu.htmlを返す
	}
    
}

