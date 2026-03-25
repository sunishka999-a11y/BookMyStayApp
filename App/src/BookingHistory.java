import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ===============================================================
 * CLASS - BookingHistory
 * ===============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Stores all confirmed reservations in order.
 *
 * Key Points:
 * - Maintains insertion order
 * - Acts as audit trail
 * - Read-only access for safety
 *
 * @version 8.0
 */

public class BookingHistory {

    // Stores confirmed bookings (chronological order)
    private List<Reservation> reservations;

    public BookingHistory() {
        reservations = new ArrayList<>();
    }

    /**
     * Adds confirmed reservation to history
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Returns read-only booking list
     */
    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }
}