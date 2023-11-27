package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	//作品番号
	@Id
	private Integer id;
	//タイトルに対応
	private String movieTitle;
	//上映時間に対応
	private Integer movieTime;
	//ジャンルに対応
	private String kind;
	//あらすじに対応
	private String summary;
}
