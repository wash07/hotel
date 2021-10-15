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

    public Room getLock() {
        Optional<Room> optionalRoom = roomRepository.findAll().stream().findFirst();
        if (!optionalRoom.isPresent()) {
            Room room = new Room();
            room.setId(1L);
            room.setCreatedDate(LocalDateTime.now());
            room.setUpdatedDate(LocalDateTime.now());
            return roomRepository.save(room);
        } else return optionalRoom.get();
    }

    public void updateLock(Room room) {
        room.setUpdatedDate(LocalDateTime.now());
        roomRepository.save(room);
    }
}