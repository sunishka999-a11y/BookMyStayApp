/**
 * UseCase3InventorySetup
 *
 * This class demonstrates centralized room inventory management
 * using a HashMap to maintain availability of different room types.
 *
 * It replaces scattered variables with a single source of truth,
 * improving scalability, consistency, and maintainability.
 *
 * @author Sunishka
 * @version 3.1
 */

import java.util.HashMap;
import java.util.Map;

// Inventory Class
class RoomInventory {

    // HashMap to store room type -> availability
    private HashMap<String, Integer> inventory;

    // Constructor to initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add or initialize room type
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Get availability of a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (increase or decrease)
    public void updateAvailability(String roomType, int change) {

        int current = inventory.getOrDefault(roomType, 0);
        int updated = current + change;

        if (updated < 0) {
            System.out.println("Error: Not enough rooms available for " + roomType);
            return;
        }

        inventory.put(roomType, updated);
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("\n===== ROOM INVENTORY =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }
    }
}

// Main Class
public class BookMyStay{

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" Hotel Booking System - Inventory");
        System.out.println("======================================");
        System.out.println("Version: 3.1\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 2);

        // Display initial inventory
        inventory.displayInventory();

        // Update inventory (simulate booking)
        System.out.println("\nBooking 1 Single Room...");
        inventory.updateAvailability("Single Room", -1);

        System.out.println("Adding 2 Double Rooms...");
        inventory.updateAvailability("Double Room", +2);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication executed successfully!");
    }
}