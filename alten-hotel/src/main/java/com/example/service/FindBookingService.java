package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;
import com.example.domain.Booking;

@Service
public class FindBookingService {
	
	@Autowired
	private BookingRepository repository;
	
	public List<Booking> findAll() {
		return repository.findAll();
	}

	public boolean validateAvailability(Booking booking) {
		if(repository.findBookings(booking.getCheckIn(), booking.getCheckOut()) == null) {
			return true;
		}
		return false;
	}
}
