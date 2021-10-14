package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.example.validations.DateRange;
import com.example.validations.ValidBookDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@ValidBookDate
@Getter
@Setter
@ToString
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String customerName;
	
	@DateRange
	@Future(message="The Check-in date should be at least a day after today")
	@NotNull(message="Check-in date is required")
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate checkIn;
	
	@DateRange
	@Future(message="The Check-out date should be a future date")
	@NotNull(message="Check-in date is required")
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate checkOut;
}