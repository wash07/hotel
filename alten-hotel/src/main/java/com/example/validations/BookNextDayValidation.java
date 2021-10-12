package com.example.validations;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.domain.Booking;

@Component
public class BookNextDayValidation implements BookingValidator{

	@Override
	public void validate(Booking booking) {
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		if(booking.getCheckIn().isBefore(tomorrow)) {
			throw new RuntimeException("You should book at least one day after the actual day");
		}
	}

}
