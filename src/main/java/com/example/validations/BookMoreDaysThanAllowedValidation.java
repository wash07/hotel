package com.example.validations;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.example.domain.Booking;

@Component
public class BookMoreDaysThanAllowedValidation implements BookingValidator{

	@Override
	public void validate(Booking booking) {
		if(booking.getCheckIn().until(booking.getCheckOut(), ChronoUnit.DAYS) > 3) {
			throw new RuntimeException("You can't reserve more than 3 days");
		}
	}

}
