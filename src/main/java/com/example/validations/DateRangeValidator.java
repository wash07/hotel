package com.example.validations;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, LocalDate>{
	
	@Override
    public void initialize(DateRange dateRange) {
    }

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		LocalDate validRange = LocalDate.now().plusDays(31);
		return value.isBefore(validRange);
	}

}
