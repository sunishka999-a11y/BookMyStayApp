import java.util.List;

/**
 * ===============================================================
 * CLASS - BookingReportService
 * ===============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Generates reports from stored booking history.
 *
 * @version 8.0
 */

public class BookingReportService {

    /**
     * Displays all bookings
     */
    public void displayAllBookings(List<Reservation> reservations) {

        System.out.println("\nBooking History");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : reservations) {
            System.out.println(
                    "Guest: " + r.getGuestName()
                            + ", Room Type: " + r.getRoomType()
            );
        }
    }

    /**
     * Generates summary report
     */
    public void generateSummaryReport(List<Reservation> reservations) {

        System.out.println("\nBooking Summary Report");

        int totalBookings = reservations.size();

        System.out.println("Total Bookings: " + totalBookings);
    }
}