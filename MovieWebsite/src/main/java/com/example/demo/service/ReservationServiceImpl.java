package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ListOfMovie;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.ListOfMovieRepository;
import com.example.demo.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	ReservationRepository repository;
	@Autowired
	ListOfMovieRepository lomRepository;
//	@Autowired
//	Account accountRepository;
	Reservation reservation;
	// 映画テーブルから映画タイトル全件取得
	@Override
	public Iterable<ListOfMovie> selectAll(){
		return lomRepository.findAll();
	}
	public Optional<Reservation> selectOneByReservationNumber(Integer reservationNumber){
		return repository.findById(reservationNumber);
	}
//	public Optional<Account>selectOneById(Integer id){
//		return accountRepository.findById(id);
//	}
	@Override
	public void insert(Reservation reservation) {
		repository.save(reservation);
	}
	// 更新
	@Override
	public void update(Reservation reservation) {
	repository.save(reservation);
	}
	// キャンセル
	@Override
	public void delete(Integer reservationNumber) {
		repository.deleteById(reservationNumber);
	}
}
