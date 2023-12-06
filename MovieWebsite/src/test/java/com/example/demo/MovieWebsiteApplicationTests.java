package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.ReservationRepository;

@SpringBootTest
class MovieWebsiteApplicationTests {
	@Autowired
	ReservationRepository repo;
	@Test
	void contextLoads() {
		assertNotNull(repo);
	}

}
