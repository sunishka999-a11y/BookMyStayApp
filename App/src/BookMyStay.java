/**
 * UseCase2RoomInitialization
 *
 * This class demonstrates basic object-oriented design using
 * abstraction, inheritance, encapsulation, and polymorphism.
 *
 * It models different room types in a hotel booking system
 * and displays their details along with static availability.
 *
 * @author Sunishka
 * @version 2.1
 */

// Abstract class
abstract class Room {

    protected String roomType;
    protected int beds;
    protected double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    // Method to display room details
    public void displayDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Beds      : " + beds);
        System.out.println("Price     : $" + price);
    }
}

// Single Room
class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 100.0);
    }
}

// Double Room
class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 180.0);
    }
}

// Suite Room
class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 300.0);
    }
}

// Main class
public class BookMyStay {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   Hotel Booking System - Room Info");
        System.out.println("======================================");
        System.out.println("Version: 2.1\n");

        // Create room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        System.out.println("Single Room Details:");
        single.displayDetails();
        System.out.println("Available Rooms: " + singleAvailable);
        System.out.println();

        System.out.println("Double Room Details:");
        doubleRoom.displayDetails();
        System.out.println("Available Rooms: " + doubleAvailable);
        System.out.println();

        System.out.println("Suite Room Details:");
        suite.displayDetails();
        System.out.println("Available Rooms: " + suiteAvailable);
        System.out.println();

        System.out.println("Application executed successfully!");
    }
}