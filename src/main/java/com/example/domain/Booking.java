package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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