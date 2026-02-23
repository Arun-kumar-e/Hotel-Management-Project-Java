package com.hotel.service;

import com.hotel.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HotelService {
    private List<Room> rooms;
    private List<Guest> guests;
    private List<Booking> bookings;

    public HotelService() {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        bookings = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, RoomType.SINGLE, 50.0));
        rooms.add(new Room(102, RoomType.SINGLE, 50.0));
        rooms.add(new Room(201, RoomType.DOUBLE, 80.0));
        rooms.add(new Room(202, RoomType.DOUBLE, 80.0));
        rooms.add(new Room(301, RoomType.SUITE, 150.0));
        rooms.add(new Room(302, RoomType.SUITE, 150.0));
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public List<Guest> getAllGuests() {
        return new ArrayList<>(guests);
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

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    public Booking createBooking(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        // Validate dates
        if (!checkOut.isAfter(checkIn)) {
            return null;
        }
        
        Room room = findRoom(roomNumber);
        if (room == null || !room.isAvailable()) {
            return null;
        }

        String bookingId = "BK" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Booking booking = new Booking(bookingId, guest, room, checkIn, checkOut);
        bookings.add(booking);
        return booking;
    }

    public boolean checkout(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                booking.checkout();
                return true;
            }
        }
        return false;
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public Guest findGuestByName(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equalsIgnoreCase(name)) {
                return guest;
            }
        }
        return null;
    }
}
