package com.example.validations;

import com.example.domain.Booking;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class BookPastDateValidation implements BookingValidator{

	@Override
	public void validate(Booking booking) {
		LocalDate actualDate = LocalDate.now();
		if(booking.getCheckIn().isBefore(actualDate) || booking.getCheckOut().isBefore(actualDate)) {
			throw new RuntimeException("You can't book an room on past dates");
		}
	}

}
