package com.example.service;

import com.example.dao.RoomRepository;
import com.example.domain.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RoomLockService {

    private final RoomRepository roomRepository;

    public RoomLockService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void updateLock() {
        Optional<Room> optionalRoom = roomRepository.findById(1L);
        if (!optionalRoom.isPresent()) {
            Room room = new Room();
            room.setId(1L);
            room.setCreatedDate(LocalDateTime.now());
            room.setUpdatedDate(LocalDateTime.now());
            roomRepository.save(room);
        } else {
            Room room = optionalRoom.get();
            room.setUpdatedDate(LocalDateTime.now());
            roomRepository.save(room);
        }
    }
}