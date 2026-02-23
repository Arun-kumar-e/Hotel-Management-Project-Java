package com.hotel.ui;

import com.hotel.service.HotelService;
import com.hotel.model.Room;
import java.util.List;
import java.util.Scanner;


public class HotelUI {
    private HotelService hotelService;
    private Scanner scanner;
    
    public HotelUI() {
        hotelService = new HotelService();
        scanner = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("Welcome to Hotel Management System");
        System.out.println("===================================");
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    displayAllRooms();
                    break;
                case 2:
                    displayAvailableRooms();
                    break;
                case 3:
                    bookRoom();
                    break;
                case 4:
                    checkoutRoom();
                    break;
                case 5:
                    System.out.println("Thank you for using Hotel Management System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
    
    private void displayMenu() {
        System.out.println("1. View All Rooms");
        System.out.println("2. View Available Rooms");
        System.out.println("3. Book a Room");
        System.out.println("4. Checkout from Room");
        System.out.println("5. Exit");
    }
    
    private void displayAllRooms() {
        System.out.println("\n--- All Rooms ---");
        List<Room> rooms = hotelService.getAllRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
    
    private void displayAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        List<Room> rooms = hotelService.getAvailableRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }
    
    private void bookRoom() {
        int roomNumber = getIntInput("Enter room number to book: ");
        if (hotelService.bookRoom(roomNumber)) {
            System.out.println("Room " + roomNumber + " booked successfully!");
        } else {
            System.out.println("Failed to book room " + roomNumber + ". Room may not exist or is already occupied.");
        }
    }
    
    private void checkoutRoom() {
        int roomNumber = getIntInput("Enter room number to checkout: ");
        if (hotelService.checkoutRoom(roomNumber)) {
            System.out.println("Checkout successful for room " + roomNumber + "!");
        } else {
            System.out.println("Failed to checkout from room " + roomNumber + ". Room may not exist or is already available.");
        }
    }
    
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
