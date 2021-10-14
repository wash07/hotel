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
	
	private BookingRepository repository;
	private RoomLockService roomLockService;
	private FindBookingService findService;
	private List<BookingValidator> validators; 

	@Autowired
	public CreateBookingService(BookingRepository repository,
								RoomLockService roomLockService,
								FindBookingService findService,
								List<BookingValidator> validators) {
		super();
		this.repository = repository;
		this.findService = findService;
		this.roomLockService = roomLockService;
		this.validators = validators;
	}



	@Transactional
	public Booking create(Booking booking) {
		roomLockService.updateLock();
		validators.forEach(validator -> validator.validate(booking));
		if(findService.validateAvailability(booking)) {
			return repository.save(booking);
		} else {
			throw new RuntimeException("There's already a booking for this date");
		}
	}

}