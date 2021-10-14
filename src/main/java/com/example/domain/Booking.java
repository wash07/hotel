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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String customerName;

	@NotNull(message="Check-in date is required")
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate checkIn;

	@NotNull(message="Check-in date is required")
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate checkOut;
}