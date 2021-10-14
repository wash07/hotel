package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final CreateBookingService createService;
	private final UpdateBookingService updateService;
	private final FindBookingService findService;
	private final DeleteBookingService deleteService;

	private Logger log = LoggerFactory.getLogger(BookingController.class);
	
	public BookingController(CreateBookingService createService,
							 UpdateBookingService updateService,
							 FindBookingService findService,
							 DeleteBookingService deleteService) {
		this.createService = createService;
		this.updateService = updateService;
		this.findService = findService;
		this.deleteService = deleteService;
	}

	@GetMapping
	public List<Booking> listBooking() {
		log.info("[RECEIVED REQUEST] Find All Bookings");
		return findService.findAll();
	}
	
	@PostMapping
	public void createBooking(@Valid @RequestBody Booking booking) {
		log.info("[RECEIVED REQUEST] Create Booking for " + booking);
		createService.create(booking);
	}
	
	@PutMapping("/{id}")
	public void updateBooking(@PathVariable("id") Long id, @Valid @RequestBody Booking booking) {
		log.info("[RECEIVED REQUEST] Update Booking for " + id + ": " + booking);
		booking.setId(id);
		updateService.update(booking);
	}
	
	@DeleteMapping("/{id}")
	public void cancelBooking(@PathVariable("id") Long id) {
		log.info("[RECEIVED REQUEST] Delete Booking for " + id);
		deleteService.delete(id);
	}
	
	
}