package com.example.validations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.domain.Booking;

class BookInAdvanceValidationTest {

	private BookMoreThanThreeDaysValidation target = new BookMoreThanThreeDaysValidation();
	
	@Test
	void givenCheckInMoreTimeThanAllowedShouldThrowException() {
		Booking booking = new Booking();
		LocalDate checkInDate = LocalDate.now().plusDays(1);
		LocalDate checkOutDate = LocalDate.now().plusDays(4);
		booking.setCheckIn(checkInDate);
		booking.setCheckOut(checkOutDate);
		
		RuntimeException ex = assertThrows(RuntimeException.class,
				() -> target.validate(booking));
		
		assertTrue(ex.getMessage().equals("You can't reserve more than 3 days"));
	}
	
	@Test
	void givenValidRangeDateShouldPassValidation(){
		Booking booking = new Booking();
		LocalDate checkInDate = LocalDate.now().plusDays(1);
		LocalDate checkOutDate = LocalDate.now().plusDays(4);
		booking.setCheckIn(checkInDate);
		booking.setCheckOut(checkOutDate);
		
		target.validate(booking);
	}

}
