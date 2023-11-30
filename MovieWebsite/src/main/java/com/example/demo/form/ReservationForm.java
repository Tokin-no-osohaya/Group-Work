package com.example.demo.form;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationForm {
	
	private Integer id;
//	@NotNull(message="タイトルを選択してください。")
	private String movieTitle;
//	@NotNull(message="人数が未入力です。")
//	@Range(min=1,message="{min}以上の数値を入力してください")
	private Integer numberOfPeople;
//	@NotBlank(message="日付を指定してください。")
	private String reservationDate;
	
	private Integer totalPrice;
	
	private LocalDateTime now = LocalDateTime.now();
	
	private Integer reservationNumber;
}
