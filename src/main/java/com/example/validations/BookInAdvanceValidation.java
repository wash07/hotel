package com.example.validations;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.domain.Booking;

@Component
public class BookInAdvanceValidation implements BookingValidator{

	@Override
	public void validate(Booking booking) {
		LocalDate inAdvance = LocalDate.now().plusDays(30);
		if(booking.getCheckIn().isAfter(inAdvance)) {
			throw new RuntimeException("You can only book within 30 days from the actual date");
		}
	}

}
