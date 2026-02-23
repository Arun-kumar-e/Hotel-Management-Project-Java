package com.hotel.service;

import com.hotel.model.Room;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for hotel operations
 */
public class HotelService {
    private List<Room> rooms;
    
    public HotelService() {
        rooms = new ArrayList<>();
        initializeRooms();
    }
    
    private void initializeRooms() {
        // Add some sample rooms
        rooms.add(new Room(101, "Single", 50.0));
        rooms.add(new Room(102, "Single", 50.0));
        rooms.add(new Room(201, "Double", 80.0));
        rooms.add(new Room(202, "Double", 80.0));
        rooms.add(new Room(301, "Suite", 150.0));
    }
    
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }
    
    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                available.add(room);
            }
        }
        return available;
    }
    
    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
    
    public boolean bookRoom(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            return true;
        }
        return false;
    }
    
    public boolean checkoutRoom(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null && !room.isAvailable()) {
            room.setAvailable(true);
            return true;
        }
        return false;
    }
}
