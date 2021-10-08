package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;

@Service
public class DeleteBookingService {
	
	@Autowired
	private BookingRepository repository;
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
