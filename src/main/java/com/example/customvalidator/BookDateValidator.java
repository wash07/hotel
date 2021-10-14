package com.example.customvalidator;

import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.domain.Booking;

public class BookDateValidator implements ConstraintValidator<ValidBookDate, Booking>{

	@Override
	public boolean isValid(Booking value, ConstraintValidatorContext context) {
		return value.getCheckIn().isBefore(value.getCheckOut()) && value.getCheckIn().until(value.getCheckOut(), ChronoUnit.DAYS) <= 3 ;
	}

	

}
