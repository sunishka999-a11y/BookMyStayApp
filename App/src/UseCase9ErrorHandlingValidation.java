/**
 * ===============================================================
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * ===============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * Demonstrates validation and safe error handling
 * during booking processing.
 *
 * @version 9.0
 */

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Booking Processing with Validation");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add valid + invalid requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("", "Double"));           // Invalid name
        queue.addRequest(new Reservation("Kumar", "InvalidType")); // Invalid type
        queue.addRequest(new Reservation("Divya", "Suite"));

        // Services
        RoomAllocationService allocationService =
                new RoomAllocationService();

        BookingValidator validator = new BookingValidator();

        // Process requests
        while (queue.hasPendingRequests()) {

            Reservation request = queue.getNextRequest();

            try {
                // ✅ Validate first (Fail-Fast)
                validator.validate(request, inventory);

                // ✅ Only valid bookings proceed
                allocationService.allocateRoom(request, inventory);

            } catch (InvalidBookingException e) {

                // ✅ Graceful failure (no crash)
                System.out.println(
                        "Booking failed: " + e.getMessage()
                );
            }
        }
    }
}