package com.example.service;

import javax.transaction.Transactional;

import com.example.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookingRepository;

@Service
public class DeleteBookingService {

	private BookingRepository repository;
	private RoomLockService roomLockService;

	@Autowired
	public DeleteBookingService(BookingRepository repository, RoomLockService roomLockService) {
		super();
		this.repository = repository;
		this.roomLockService = roomLockService;
	}

	@Transactional
	public void delete(Long id) {
		Room room = roomLockService.getLock();
		repository.deleteById(id);
		roomLockService.updateLock(room);
	}

}