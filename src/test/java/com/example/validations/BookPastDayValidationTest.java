package com.example.validations;

import com.example.domain.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookPastDayValidationTest {

	private BookPastDateValidation target = new BookPastDateValidation();
	
	@Test
	void givenDateBeforeActualDayShouldThrowException() {
		Booking booking = new Booking();
		LocalDate invalidCheckInDate = LocalDate.now().minusDays(3);
		LocalDate invalidCheckOutDate = LocalDate.now().minusDays(2);
		booking.setCheckIn(invalidCheckInDate);
		booking.setCheckOut(invalidCheckOutDate);

		RuntimeException ex = assertThrows(RuntimeException.class,
				() -> target.validate(booking));
		
		assertTrue(ex.getMessage().equals("You can't book an room on past dates"));
	}
	
	@Test
	void givenValidDateShouldPassValidation(){
		Booking booking = new Booking();
		LocalDate validCheckInDate = LocalDate.now();
		LocalDate validCheckOutDate = LocalDate.now();
		booking.setCheckIn(validCheckInDate);
		booking.setCheckOut(validCheckOutDate);

		target.validate(booking);
	}

}
