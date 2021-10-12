package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;
import com.example.domain.Booking;
import com.example.validations.BookingValidator;

@Service
public class CreateBookingService {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private FindBookingService findService;
	
	@Autowired
	private List<BookingValidator> validators; 
	
	@Transactional
	public void create(Booking booking) {
		validators.forEach(validator -> validator.validate(booking));
		if(findService.validateAvailability(booking)) {
			repository.save(booking);	
		}
	}

}