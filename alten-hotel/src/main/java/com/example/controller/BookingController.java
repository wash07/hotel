package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Booking;
import com.example.service.CreateBookingService;
import com.example.service.DeleteBookingService;
import com.example.service.FindBookingService;
import com.example.service.UpdateBookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	private CreateBookingService createService;
	
	private UpdateBookingService updateService;
	
	private FindBookingService findService;
	
	private DeleteBookingService deleteService;

	@GetMapping
	public List<Booking> listBooking() {
		return findService.findAll();
	}
	
	@PostMapping
	public void createBooking(Booking booking) {
		createService.create(booking);
		return ResponseEntity;
	}
	
	@PutMapping("")
	public void updateBooking(Booking booking) {
		updateService.update(booking);
	}
	
	@DeleteMapping("/{id}")
	public void cancelBooking(Long id) {
		deleteService.delete(id);
	}
	
	@GetMapping("/checkAvailability")
	public void checkAvailability(Booking booking) {
		findService.findAll();
	}
	
}
