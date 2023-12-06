package com.example.demo.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationForm {
	
	private Integer id;
	@NotBlank(message="タイトルを選択してください。")
	private String movieTitle;
	@NotNull(message="人数が未入力です。")
	@Range(min=1,message="{min}以上の数値を入力してください")
	private Integer numberOfPeople;
	@NotBlank(message="日付を指定してください。")
	@Future(message="範囲外の日付です。")
	private LocalDate reservationDate;
	
	private Integer totalPrice;
	
	private LocalDateTime now = LocalDateTime.now();
	
	private Integer reservationNumber;
}
