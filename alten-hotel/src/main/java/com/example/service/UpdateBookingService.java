package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;
import com.example.domain.Booking;

@Service
public class UpdateBookingService {
	
	@Autowired
	private BookingRepository repository;
	
	public void update(Booking booking) {
		repository.save(booking);
	}

}
