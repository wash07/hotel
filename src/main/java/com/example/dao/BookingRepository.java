package com.example.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{
	
	@Query("SELECT b FROM Booking b WHERE ?1 BETWEEN b.checkIn AND b.checkOut OR ?2 BETWEEN b.checkIn AND b.checkOut")
	Booking findBookings(LocalDate checkIn, LocalDate checkOut);
	
	Booking findByid(Long id);
}
