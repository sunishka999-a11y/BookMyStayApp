/**
 * ===============================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ===============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Extends Use Case 6 by storing confirmed bookings
 * and generating reports.
 *
 * @version 8.0
 */

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("Booking Processing with History");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Queue (FIFO)
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Allocation service
        RoomAllocationService allocationService =
                new RoomAllocationService();

        // NEW: Booking history
        BookingHistory history = new BookingHistory();

        // Process bookings
        while (queue.hasPendingRequests()) {

            Reservation request = queue.getNextRequest();

            // Allocate room (Use Case 6)
            allocationService.allocateRoom(request, inventory);

            // Store confirmed booking (Use Case 8)
            history.addReservation(request);
        }

        // Reporting
        BookingReportService reportService =
                new BookingReportService();

        reportService.displayAllBookings(history.getReservations());
        reportService.generateSummaryReport(history.getReservations());
    }
}