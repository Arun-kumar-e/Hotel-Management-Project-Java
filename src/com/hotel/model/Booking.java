package com.hotel.model;

import java.time.LocalDate;

public class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;
    private BookingStatus status;

    public Booking(String bookingId, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        this.totalPrice = calculatePrice();
        this.status = BookingStatus.CONFIRMED;
        room.setAvailable(false);
    }

    private double calculatePrice() {
        long nights = java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return nights * room.getPrice();
    }

    public String getBookingId() { return bookingId; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public double getTotalPrice() { return totalPrice; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }

    public void checkout() {
        room.setAvailable(true);
        this.status = BookingStatus.CHECKED_OUT;
    }

    @Override
    public String toString() {
        return "Booking " + bookingId + ": " + guest.getName() + " - Room " + 
               room.getRoomNumber() + " - " + checkInDate + " to " + checkOutDate + 
               " - $" + totalPrice;
    }
}
