# Hotel Management System

A Java-based console application for managing hotel operations including guest management, room bookings, and checkout processes.

## Features

- **Guest Management**: Add and view guest information
- **Room Management**: View available rooms and room types
- **Booking System**: Create and manage room bookings with date validation
- **Checkout Process**: Handle guest checkouts and update room availability
- **Booking Status Tracking**: Track booking status (Confirmed, Checked In, Checked Out, Cancelled)

## Project Structure

```
src/com/hotel/
├── Main.java                 # Application entry point
├── model/                    # Data models
│   ├── Guest.java           # Guest entity with equals/hashCode
│   ├── Room.java            # Room entity with RoomType enum
│   ├── Booking.java         # Booking entity with status tracking
│   ├── RoomType.java        # Enum: SINGLE, DOUBLE, SUITE
│   └── BookingStatus.java   # Enum: CONFIRMED, CHECKED_IN, CHECKED_OUT, CANCELLED
├── service/                  # Business logic
│   └── HotelService.java    # Core hotel management services
└── ui/                       # User interface
    └── HotelUI.java         # Console-based user interface
```

## Getting Started

### Prerequisites

- Java 8 or higher
- An IDE or text editor for Java development

### Running the Application

1. Compile the Java files:
   ```bash
   javac src/com/hotel/*.java src/com/hotel/*/*.java
   ```

2. Run the application:
   ```bash
   java com.hotel.Main
   ```

### Usage

The application provides a console-based menu with the following options:

1. **Add Guest**: Register a new guest with name, email, and phone
2. **View All Guests**: Display all registered guests
3. **View Rooms**: Show all rooms with their availability status
4. **Make Booking**: Create a new booking for a guest
5. **View Bookings**: Display all current bookings
6. **Checkout**: Process guest checkout and free up rooms
7. **Exit**: Close the application

## Key Features

### Room Types
- **SINGLE**: Basic single occupancy rooms ($50/night)
- **DOUBLE**: Double occupancy rooms ($80/night)
- **SUITE**: Premium suite rooms ($150/night)

### Booking Status
- **CONFIRMED**: Booking is confirmed and room is reserved
- **CHECKED_IN**: Guest has checked in
- **CHECKED_OUT**: Guest has checked out and room is available
- **CANCELLED**: Booking was cancelled

### Data Validation
- Checkout date must be after check-in date
- Room must be available for booking
- Guest must exist in the system

## Technical Details

### Design Patterns
- **MVC Architecture**: Separation of concerns with Model, View (UI), and Controller (Service)
- **Enum Usage**: Type-safe enums for RoomType and BookingStatus
- **Proper Encapsulation**: Private fields with public getters/setters

### Key Methods
- `Guest.equals()` and `Guest.hashCode()`: Based on email for uniqueness
- `HotelService.createBooking()`: Includes date validation
- `HotelService.findGuestByName()`: Case-insensitive guest lookup

## Future Enhancements

- [ ] Database integration for persistent storage
- [ ] GUI interface using JavaFX or Swing
- [ ] Payment processing integration
- [ ] Advanced room search and filtering
- [ ] Reporting and analytics
- [ ] Multi-user support with authentication

## License

This project is open source and available under the MIT License.
