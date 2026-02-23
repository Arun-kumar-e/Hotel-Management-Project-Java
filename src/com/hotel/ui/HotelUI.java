package com.hotel.ui;

import com.hotel.model.*;
import com.hotel.service.HotelService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class HotelUI {
    private HotelService hotelService;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;

    public HotelUI() {
        hotelService = new HotelService();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public void start() {
        System.out.println("=== HOTEL MANAGEMENT SYSTEM ===");
        
        while (true) {
            showMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1: addGuest(); break;
                case 2: viewGuests(); break;
                case 3: viewRooms(); break;
                case 4: makeBooking(); break;
                case 5: viewBookings(); break;
                case 6: checkout(); break;
                case 7: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add Guest");
        System.out.println("2. View All Guests");
        System.out.println("3. View Rooms");
        System.out.println("4. Make Booking");
        System.out.println("5. View Bookings");
        System.out.println("6. Checkout");
        System.out.println("7. Exit");
    }

    private void addGuest() {
        System.out.println("\n--- ADD GUEST ---");
        String name = getStringInput("Name: ");
        String email = getStringInput("Email: ");
        String phone = getStringInput("Phone: ");
        
        Guest guest = new Guest(name, email, phone);
        hotelService.addGuest(guest);
        System.out.println("Guest added successfully!");
    }

    private void viewGuests() {
        System.out.println("\n--- ALL GUESTS ---");
        List<Guest> guests = hotelService.getAllGuests();
        if (guests.isEmpty()) {
            System.out.println("No guests found.");
        } else {
            for (Guest guest : guests) {
                System.out.println(guest);
            }
        }
    }

    private void viewRooms() {
        System.out.println("\n--- ALL ROOMS ---");
        List<Room> rooms = hotelService.getAllRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private void makeBooking() {
        System.out.println("\n--- MAKE BOOKING ---");
        
        viewGuests();
        String guestName = getStringInput("Enter guest name: ");
        Guest guest = hotelService.findGuestByName(guestName);
        if (guest == null) {
            System.out.println("Guest not found!");
            return;
        }

        System.out.println("\nAvailable Rooms:");
        List<Room> availableRooms = hotelService.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available!");
            return;
        }
        
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        int roomNumber = getIntInput("Enter room number: ");
        LocalDate checkIn = getDateInput("Check-in date (YYYY-MM-DD): ");
        LocalDate checkOut = getDateInput("Check-out date (YYYY-MM-DD): ");

        Booking booking = hotelService.createBooking(guest, roomNumber, checkIn, checkOut);
        if (booking != null) {
            System.out.println("Booking successful!");
            System.out.println(booking);
        } else {
            System.out.println("Booking failed! Room may not be available or dates may be invalid.");
        }
    }

    private void viewBookings() {
        System.out.println("\n--- ALL BOOKINGS ---");
        List<Booking> bookings = hotelService.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    private void checkout() {
        System.out.println("\n--- CHECKOUT ---");
        String bookingId = getStringInput("Enter booking ID: ");
        
        if (hotelService.checkout(bookingId)) {
            System.out.println("Checkout successful!");
        } else {
            System.out.println("Booking not found!");
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return LocalDate.parse(scanner.nextLine().trim(), dateFormatter);
            } catch (Exception e) {
                System.out.println("Please enter a valid date (YYYY-MM-DD)!");
            }
        }
    }
}
