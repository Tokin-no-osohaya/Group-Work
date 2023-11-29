package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@Controller
public class RegisterController {

 @Autowired
 private UserService userService;

 @GetMapping("/register")
 public String register() {
     return "register"; // register.htmlを返す
 }

 @PostMapping("/register")
 public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
     User existingUser = userService.getUserByUsername(username);
     if (existingUser != null) {
         model.addAttribute("error", "ユーザー名は既に存在します");
         return "register";
     }

     User newUser = new User();
     newUser.setUsername(username);
     newUser.setPassword(password);
     userService.saveUser(newUser);

     // 8桁のランダムなIDを生成
     String randomId = generateRandomId();
     model.addAttribute("randomId", randomId);

     return "registration-success"; // registration-success.htmlを返す
 }

 private String generateRandomId() {
     // 8桁のランダムな数字を生成する処理
	 Random random = new Random();
     int randomInt = 10000000 + random.nextInt(90000000); // 10000000 から 99999999 の間のランダムな数値
     return String.format("%08d", randomInt);
 }
}

