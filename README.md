# Hotel Management System

A console-based Hotel Management System built in Java that allows users to manage hotel room bookings, check-ins, and check-outs.

## Features

- **Room Management**: View all rooms and their availability status
- **Booking System**: Book available rooms for guests
- **Checkout System**: Process guest checkouts and make rooms available again
- **Room Types**: Support for different room types (Single, Double, Suite)
- **User-Friendly Interface**: Simple console-based menu system

## Project Structure

```
Hotel-Management-Project-Java/
├── src/
│   └── com/
│       └── hotel/
│           ├── Main.java              # Entry point of the application
│           ├── model/
│           │   └── Room.java          # Room model class
│           ├── service/
│           │   └── HotelService.java  # Business logic for hotel operations
│           └── ui/
│               └── HotelUI.java       # User interface and console interactions
├── README.md                          # This file
└── .gitignore                         # Git ignore file
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE or text editor for Java development
- Command line/terminal

## How to Run

1. **Clone the repository** (if you haven't already):
   ```bash
   git clone https://github.com/yourusername/Hotel-Management-Project-Java.git
   cd Hotel-Management-Project-Java
   ```

2. **Compile the Java files**:
   ```bash
   javac src/com/hotel/*.java src/com/hotel/model/*.java src/com/hotel/service/*.java src/com/hotel/ui/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp src com.hotel.Main
   ```

## Usage

Once the application starts, you'll see a menu with the following options:

1. **View All Rooms** - Displays all rooms in the hotel with their current status
2. **View Available Rooms** - Shows only the rooms that are currently available for booking
3. **Book a Room** - Allows you to book an available room by entering the room number
4. **Checkout from Room** - Processes checkout and makes the room available again
5. **Exit** - Closes the application

### Sample Room Configuration

The system comes pre-configured with the following rooms:
- Room 101: Single - $50.0/night
- Room 102: Single - $50.0/night
- Room 201: Double - $80.0/night
- Room 202: Double - $80.0/night
- Room 301: Suite - $150.0/night

## Architecture

The application follows a layered architecture:

- **Model Layer**: Contains the `Room` class that represents hotel rooms
- **Service Layer**: `HotelService` class handles all business logic and data management
- **UI Layer**: `HotelUI` class manages user interactions and console display
- **Main Class**: Entry point that initializes and starts the application

## Future Enhancements

Potential improvements for future versions:

- [ ] Guest management system
- [ ] Booking history and reports
- [ ] Database integration for persistent storage
- [ ] GUI interface using JavaFX or Swing
- [ ] Room cleaning schedule management
- [ ] Payment processing integration
- [ ] Multi-user support with authentication

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

- [Your Name] - Initial work

## Acknowledgments

- Thanks to anyone who contributes to this project
- Built as a learning project for Java application development
