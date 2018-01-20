package exercises.exercise3;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private static final int START_HOUR = 9;
    private static final int END_HOUR = 17;

    private List<Booking> bookings = new ArrayList<>();

    public void book(Booking booking) throws DoubleBookingException, InvalidBookingException {
        if (bookings.contains(booking)) {
            throw new DoubleBookingException();
        } else if (isInvalidBooking(booking)) {
            throw new InvalidBookingException();
        }

        bookings.add(booking);
    }

    private boolean isInvalidBooking(Booking booking) {
        return isOutsideOfBookingHours(booking) || isBookingNotAnHourly(booking);
    }

    private boolean isBookingNotAnHourly(Booking booking) {
        return booking.getStartHour() % 1 != 0 || booking.getEndHour() % 1 != 0;
    }

    private boolean isOutsideOfBookingHours(Booking booking) {
        return booking.getStartHour() < START_HOUR || booking.getEndHour() <= START_HOUR ||
                booking.getEndHour() > END_HOUR || booking.getStartHour() >= END_HOUR;
    }

    public List<Booking> retrieveBookings() {
        return bookings;
    }
}