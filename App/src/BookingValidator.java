import java.util.Map;

/**
 * ===============================================================
 * CLASS - BookingValidator
 * ===============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * Validates booking input and system state
 * before processing.
 *
 * @version 9.0
 */

public class BookingValidator {

    /**
     * Validates reservation request
     */
    public void validate(Reservation reservation,
                         RoomInventory inventory)
            throws InvalidBookingException {

        String guestName = reservation.getGuestName();
        String roomType = reservation.getRoomType();

        Map<String, Integer> availability =
                inventory.getRoomAvailability();

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException(
                    "Guest name cannot be empty"
            );
        }

        // Validate room type
        if (!availability.containsKey(roomType)) {
            throw new InvalidBookingException(
                    "Invalid room type: " + roomType
            );
        }

        // Validate availability
        if (availability.get(roomType) <= 0) {
            throw new InvalidBookingException(
                    "No rooms available for type: " + roomType
            );
        }
    }
}