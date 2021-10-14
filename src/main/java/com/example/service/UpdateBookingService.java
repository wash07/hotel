package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;
import com.example.domain.Booking;
import com.example.validations.BookingValidator;

@Service
public class UpdateBookingService {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private FindBookingService findService;
	
	@Autowired
	private List<BookingValidator> validators; 
	
	@Transactional
	public void update(Booking booking) {
		validators.forEach(validator -> validator.validate(booking));
		Booking alreadyBooked = findService.findById(booking.getId());
		if((alreadyBooked.getCheckIn().isEqual(booking.getCheckIn()) && alreadyBooked.getCheckOut().isEqual(booking.getCheckOut()))
				|| findService.validateAvailability(booking)) {
			repository.save(booking);	
		}
	}

}
