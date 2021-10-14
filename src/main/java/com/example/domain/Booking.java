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

import com.example.customvalidator.DateRange;
import com.example.customvalidator.ValidBookDate;

@Entity
@Table
@ValidBookDate
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
