package com.example.validations;

import com.example.domain.Booking;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookCheckOutBeforeCheckInDayValidation implements BookingValidator{

	@Override
	public void validate(Booking booking) {
		if(booking.getCheckOut().isBefore(booking.getCheckIn())) {
			throw new RuntimeException("Your check-out must be a date after the check-in date");
		}
	}

}
