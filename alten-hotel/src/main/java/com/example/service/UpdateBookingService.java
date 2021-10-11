package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;
import com.example.domain.Booking;

@Service
public class UpdateBookingService {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private FindBookingService findService;
	
	@Transactional
	public void update(Booking booking) {
		if(findService.validateAvailability(booking)) {
			repository.save(booking);	
		}
	}

}
