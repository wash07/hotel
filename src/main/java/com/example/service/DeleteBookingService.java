package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;

@Service
public class DeleteBookingService {
	
	@Autowired
	private BookingRepository repository;
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
