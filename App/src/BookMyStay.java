/**
 * UseCase4RoomSearch
 *
 * This class demonstrates room search functionality using
 * read-only access to centralized inventory.
 *
 * It ensures:
 * - No modification of inventory (read-only)
 * - Only available rooms are shown
 * - Room details come from domain objects
 *
 * @author Sunishka
 * @version 4.0
 */

import java.util.*;

// -------------------- DOMAIN MODEL --------------------
abstract class Room {

    protected String roomType;
    protected int beds;
    protected double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Beds      : " + beds);
        System.out.println("Price     : $" + price);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 100.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 180.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 300.0);
    }
}

// -------------------- INVENTORY --------------------
class RoomInventory {

    private HashMap<String, Integer> inventory = new HashMap<>();

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    // READ-ONLY access
    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public Set<String> getAllRoomTypes() {
        return inventory.keySet();
    }
}

// -------------------- SEARCH SERVICE --------------------
class RoomSearchService {

    public static void searchAvailableRooms(RoomInventory inventory, List<Room> rooms) {

        System.out.println("\n===== AVAILABLE ROOMS =====");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // Validation: show only available rooms
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println();
            }
        }
    }
}

// -------------------- MAIN CLASS --------------------
public class BookMyStay{

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" Hotel Booking System - Room Search");
        System.out.println("======================================");
        System.out.println("Version: 4.0\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 0); // unavailable
        inventory.addRoomType("Suite Room", 2);

        // Room domain objects
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        // Perform search (READ ONLY)
        RoomSearchService.searchAvailableRooms(inventory, rooms);

        System.out.println("Search completed (No inventory changes).");
    }
}