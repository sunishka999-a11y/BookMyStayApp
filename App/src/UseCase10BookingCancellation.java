/**
 * ===============================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ===============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * Demonstrates safe cancellation of bookings
 * and restoration of inventory using LIFO logic.
 *
 * @version 10.0
 */

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking & Cancellation Processing");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Allocation service
        RoomAllocationService allocationService =
                new RoomAllocationService();

        // Cancellation service
        CancellationService cancellationService =
                new CancellationService();

        // Create reservations
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");

        // Allocate rooms
        allocationService.allocateRoom(r1, inventory);
        allocationService.allocateRoom(r2, inventory);

        // Track active bookings
        cancellationService.addReservation(r1);
        cancellationService.addReservation(r2);

        // Cancel bookings (LIFO style concept)
        cancellationService.cancelReservation(r2, inventory);
        cancellationService.cancelReservation(r1, inventory);

        // Invalid cancellation
        cancellationService.cancelReservation(r1, inventory);
    }
}