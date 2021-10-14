package com.example.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Booking>> listBooking() {
		log.info("[RECEIVED REQUEST] Find All Bookings");
		return ResponseEntity.ok(findService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking bookingRequest) {
		log.info("[RECEIVED REQUEST] Create Booking for " + bookingRequest);
		Booking booking = createService.create(bookingRequest);
		return ResponseEntity.created(URI.create(booking.getId().toString())).body(booking);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") Long id, @Valid @RequestBody Booking booking) {
		log.info("[RECEIVED REQUEST] Update Booking for " + id + ": " + booking);
		booking.setId(id);
		return ResponseEntity.accepted().body(updateService.update(booking));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> cancelBooking(@PathVariable("id") Long id) {
		log.info("[RECEIVED REQUEST] Delete Booking for " + id);
		deleteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}