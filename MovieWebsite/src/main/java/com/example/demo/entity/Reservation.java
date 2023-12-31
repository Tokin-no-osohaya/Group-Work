package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 予約テーブル用
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	//ユーザID
	private Integer id;
	//予約番号
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationNumber;
	//予約した日付（時間）
	private LocalDateTime managementTime;
	//映画タイトル
	private String movieTitle;
	//人数
	private Integer numberOfPeople;
	//合計金額
	private Integer totalPrice;
	//予約日
	private Date reservationDate;
	
}

