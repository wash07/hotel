package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private CreateBookingService createService;
	
	@Autowired
	private UpdateBookingService updateService;
	
	@Autowired
	private FindBookingService findService;
	
	@Autowired
	private DeleteBookingService deleteService;

	@GetMapping
	public List<Booking> listBooking() {
		return findService.findAll();
	}
	
	@PostMapping
	public void createBooking(@RequestBody Booking booking) {
		createService.create(booking);
	}
	
	@PutMapping("/{id}")
	public void updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking) {
		updateService.update(booking);
	}
	
	@DeleteMapping("/{id}")
	public void cancelBooking(@PathVariable("id") Long id) {
		deleteService.delete(id);
	}
	
	
}
