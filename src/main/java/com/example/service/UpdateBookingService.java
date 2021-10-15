package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;
import com.example.domain.Booking;
import com.example.validations.BookingValidator;

@Service
public class UpdateBookingService {

	private BookingRepository repository;

	private FindBookingService findService;

	private RoomLockService roomLockService;

	private List<BookingValidator> validators;

	@Autowired
	public UpdateBookingService(BookingRepository repository,
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
	public Booking update(Booking booking) {
		Room room = roomLockService.getLock();
		validators.forEach(validator -> validator.validate(booking));
		Booking alreadyBooked = findService.findById(booking.getId());
		if((alreadyBooked.getCheckIn().isEqual(booking.getCheckIn()) && alreadyBooked.getCheckOut().isEqual(booking.getCheckOut()))
				|| findService.validateAvailability(booking)) {
			Booking updatedBooking = repository.save(booking);
			roomLockService.updateLock(room);
			return updatedBooking;
		} else {
			throw new RuntimeException("Couldn't update the booking request");
		}
	}

}