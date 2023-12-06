package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Reservation;
import com.example.demo.form.ReservationForm;
import com.example.demo.service.ReservationService;
@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	ReservationService service;
	
	@ModelAttribute
	public ReservationForm add() {
		ReservationForm form = new ReservationForm();
		form.setMovieTitle("");
		return form;
	}

	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); 
	//	@ModelAttribute
	//	public ReservationForm setupForm() {
	//		return new ReservationForm();
	//	}

	//予約ページにリンクする
	@GetMapping
	public String entryView(Model model) {
		Iterable<Movie> list = service.selectAll();
		model.addAttribute("list",list);
		LocalDate today=LocalDate.now();
		LocalDate maxDate=today.plusDays(30);
		model.addAttribute("today",today);
		model.addAttribute("maxDate",maxDate);
		return "entry";
	}
	
	// confirmファイルに返す
	@PostMapping("confirm")
	public String confirmView(@Validated ReservationForm reservationForm,BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
		if(reservationForm.getReservationDate()!=null&&reservationForm.getReservationDate().isAfter(LocalDate.now().plusDays(30))) {
			 FieldError fieldError = new FieldError("reservationForm", "reservationDate", "予約日は30日後までです。");
	           bindingResult.addError(fieldError);
		}
		if(bindingResult.hasErrors()) {
			Iterable<Movie> list = service.selectAll();
			model.addAttribute("list",list);
			return "entry";
		}
		//		System.out.println(reservationForm);
		reservationForm.setTotalPrice(reservationForm.getNumberOfPeople()*1800);
		//		model.addAttribute("totalPrice",reservationForm.getTotalPrice());
		return "confirm";
	}

	// confirmCompファイルに返す
	@PostMapping("confirmComp")
	public String confirmCompView(ReservationForm reservationForm,Model model) {
		//		System.out.println(reservationForm);
		Reservation reservation = remakeEntity(reservationForm);
		service.insert(reservation);//DB登録
				Optional<Reservation>reservationOpt = service.selectOneByReservationNumber(reservation.getReservationNumber());
				Optional<ReservationForm>reservationFormOpt = reservationOpt.map(t ->remakeForm(t));
				ReservationForm form = reservationFormOpt.get();
				model.addAttribute("reservationDate",form.getReservationDate());
				model.addAttribute("movieTitle",form.getMovieTitle());
				model.addAttribute("numberOfPeople",form.getNumberOfPeople());
				model.addAttribute("totalPrice",form.getTotalPrice());
				model.addAttribute("reservationNumber",form.getReservationNumber());
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
				String managementTime = fmt.format(form.getNow());
				model.addAttribute("managementTime",managementTime);
				reservation.setTotalPrice(reservation.getTotalPrice());
//				reservation.setManagementTime(reservation.getManagementTime());

		return "confirmComp";
	}
	
	//EntityからFormへ詰め直し
	private ReservationForm remakeForm(Reservation reservation) {
		ReservationForm form=new ReservationForm();
		form.setId(reservation.getId());
		form.setMovieTitle(reservation.getMovieTitle());
		form.setNumberOfPeople(reservation.getNumberOfPeople());
		form.setNow(reservation.getManagementTime());
//		form.setReservationDate(f.format(reservation.getReservationDate()));
		form.setTotalPrice(reservation.getTotalPrice());
		form.setReservationNumber(reservation.getReservationNumber());
		return form;	
	}
	//FormからEntity

	public Reservation remakeEntity(ReservationForm form) {
		Reservation reservation = new Reservation();
		reservation.setId(form.getId());
		reservation.setMovieTitle(form.getMovieTitle());
		reservation.setNumberOfPeople(form.getNumberOfPeople());
		reservation.setManagementTime(form.getNow());
		reservation.setReservationNumber(form.getReservationNumber());
		reservation.setTotalPrice(form.getTotalPrice());
		//		↓変更に伴ってtry-catchが増えています。
//		try {
//			reservation.setReservationDate(new Date(f.parse(form.getReservationDate()).getTime()));
//		} catch (ParseException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
		return reservation;
	}


}
