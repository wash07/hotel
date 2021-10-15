package com.example.validations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.domain.Booking;

class BookInAdvanceValidationTest {

	private BookInAdvanceValidation target = new BookInAdvanceValidation();
	
	@Test
	void givenDateInAdvanceShouldThrowException() {
		Booking booking = new Booking();
		LocalDate invalidDate = LocalDate.now().plusDays(31);
		booking.setCheckIn(invalidDate);
		
		RuntimeException ex = assertThrows(RuntimeException.class,
				() -> target.validate(booking));
		
		assertTrue(ex.getMessage().equals("You can only book within 30 days from the actual date"));
	}
	
	@Test
	void givenValidDateShouldPassValidation(){
		Booking booking = new Booking();
		LocalDate validDate = LocalDate.now().plusDays(1);
		booking.setCheckIn(validDate);
		
		target.validate(booking);
	}

}
