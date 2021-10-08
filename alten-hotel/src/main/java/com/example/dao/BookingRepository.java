package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{
	
	//@Query(value = "SELECT b FROM Booking b WHERE b.checkin >= ?1 AND b.checkout <= ?1")
	//void checkAvailability(LocalDate date);
}
