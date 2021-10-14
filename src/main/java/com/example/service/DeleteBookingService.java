package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;

@Service
public class DeleteBookingService {
	
	private BookingRepository repository;
	
	@Autowired
	public DeleteBookingService(BookingRepository repository) {
		super();
		this.repository = repository;
	}



	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
