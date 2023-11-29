package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleId {
	@Id
	private Long id;
	
	@NotNull
	private String username;
}
