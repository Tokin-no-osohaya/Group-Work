package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleId {
	@Id
	private Integer id;
	
	@NotNull
	private String username;

	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
