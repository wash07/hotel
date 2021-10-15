package com.example.validations;

import com.example.domain.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookCheckOutBeforeCheckInValidationTest {

	private BookCheckOutBeforeCheckInDayValidation target = new BookCheckOutBeforeCheckInDayValidation();
	
	@Test
	void givenCheckOutBeforeCheckInShouldThrowException() {
		Booking booking = new Booking();
		LocalDate invalidCheckInDate = LocalDate.now().plusDays(2);
		LocalDate invalidCheckOutDate = LocalDate.now().plusDays(1);
		booking.setCheckIn(invalidCheckInDate);
		booking.setCheckOut(invalidCheckOutDate);
		
		RuntimeException ex = assertThrows(RuntimeException.class,
				() -> target.validate(booking));
		
		assertTrue(ex.getMessage().equals("Your check-out must be a date after the check-in date"));
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
