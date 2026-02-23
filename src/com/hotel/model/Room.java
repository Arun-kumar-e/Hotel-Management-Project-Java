package com.hotel.model;

public class Room {
    private int roomNumber;
    private RoomType roomType;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, RoomType roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() { return roomNumber; }
    public RoomType getRoomType() { return roomType; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + roomType + ") - $" + price + "/night - " + 
               (isAvailable ? "Available" : "Occupied");
    }
}
