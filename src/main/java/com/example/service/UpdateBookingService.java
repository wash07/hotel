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
	
	private BookingRepository repository;
	
	private FindBookingService findService;
	
	private List<BookingValidator> validators; 
	
	@Autowired
	public UpdateBookingService(BookingRepository repository, FindBookingService findService,
			List<BookingValidator> validators) {
		super();
		this.repository = repository;
		this.findService = findService;
		this.validators = validators;
	}



	@Transactional
	public Booking update(Booking booking) {
		validators.forEach(validator -> validator.validate(booking));
		Booking alreadyBooked = findService.findById(booking.getId());
		if((alreadyBooked.getCheckIn().isEqual(booking.getCheckIn()) && alreadyBooked.getCheckOut().isEqual(booking.getCheckOut()))
				|| findService.validateAvailability(booking)) {
			return repository.save(booking);	
		} else {
			throw new RuntimeException("Couldn't update the booking request");
		}
	}

}