package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class LoginSecurity {
	@Bean
	DefaultSecurityFilterChain signinSecurity(HttpSecurity http) throws Exception {
		http
				.formLogin(form -> form
						//ログイン処理のパス
						.loginProcessingUrl("/authenticate")
						//ログインページ
						.loginPage("/login")
						//ログインエラー時の遷移先
						.failureUrl("/login?error")
						//ログイン成功時の遷移先
						.defaultSuccessUrl("/menu", true)
						// ログイン画面は未ログインでもアクセス可能
						.permitAll())
				.logout(logout -> logout
						//ログアウト時の遷移先
						.logoutSuccessUrl("/login?logout"))
				.authorizeHttpRequests(authz -> authz
						// 「/login」と「register」はすべて許可
						.requestMatchers("/login", "/register").permitAll()
						// 他の URL はログイン後のみアクセス可能
						.anyRequest().authenticated())
				.exceptionHandling((exceptionHandling) -> exceptionHandling
						.accessDeniedPage("/error"));
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		// System.out.println(new BCryptPasswordEncoder().encode("bucho"));
		return new BCryptPasswordEncoder();
	}
}
