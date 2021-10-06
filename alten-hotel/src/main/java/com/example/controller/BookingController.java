package com.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Booking;
import com.example.service.CreateBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	private CreateBookingService service;

	@GetMapping("/list")
	public void listBooking() {
		
	}
	
	@PostMapping("/create")
	public void createBooking(Booking booking) {
		
	}
	
	@PutMapping("/update")
	public void updateBooking(Booking booking) {
		
	}
	
	@DeleteMapping("/cancel/{id}")
	public void cancelBooking(Booking booking) {
		
	}
	
	@GetMapping("/checkAvailability")
	public void checkAvailability(Booking booking) {
		
	}
	
}
