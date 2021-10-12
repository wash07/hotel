package com.example.validations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.domain.Booking;

class BookNextDayValidationTest {

	private BookNextDayValidation target = new BookNextDayValidation();
	
	@Test
	void givenDateBeforeNextDayShouldThrowException() {
		Booking booking = new Booking();
		LocalDate invalidDate = LocalDate.now();
		booking.setCheckIn(invalidDate);
		
		RuntimeException ex = assertThrows(RuntimeException.class,
				() -> target.validate(booking));
		
		assertTrue(ex.getMessage().equals("You should book at least one day after the actual day"));
	}
	
	@Test
	void givenValidDateShouldPassValidation(){
		Booking booking = new Booking();
		LocalDate validDate = LocalDate.now().plusDays(1);
		booking.setCheckIn(validDate);
		
		target.validate(booking);
	}

}
