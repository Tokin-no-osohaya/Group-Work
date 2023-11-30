package com.example.demo.service;


import java.util.Optional;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Reservation;

public interface ReservationService {
	// 映画タイトル取得
	Iterable<Movie> selectAll();
	// 予約番号取得
	Optional<Reservation> selectOneByReservationNumber(Integer reservationNumber);
	// アカウントID取得
//	Optional<Account> selectOneById();
	// 登録
	void insert(Reservation reservation);
	//更新・変更
	void update(Reservation reservation);
	//キャンセル
	void delete(Integer id);
	

}
