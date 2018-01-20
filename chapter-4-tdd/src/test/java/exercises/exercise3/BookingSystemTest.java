package exercises.exercise3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BookingSystemTest {
    private static final int EXPECTED_SIZE = 3;

    private BookingSystem bookingSystem;

    public Object[] invalidBookings() {
        return new Object[] {
                new Object[] {7.0, 8.0},
                new Object[] {23.0, 0.0},
                new Object[] {10.5, 11.5}
        };
    }

    @Before
    public void init() {
        bookingSystem = new BookingSystem();
    }

    @Test
    public void should_ProvideBookedHours_When_Queried() throws DoubleBookingException, InvalidBookingException {
        // Arrange
        Booking booking1 = new Booking(10.0, 11.0);
        Booking booking2 = new Booking(13.0, 14.0);
        Booking booking3 = new Booking(14.0, 15.0);
        List<Booking> expectedBookingList = asList(booking1, booking2, booking3);
        bookingSystem.book(booking1);
        bookingSystem.book(booking2);
        bookingSystem.book(booking3);

        // Act
        List<Booking> actualBookingList = bookingSystem.retrieveBookings();

        // Assert
        assertTrue(actualBookingList.size() == EXPECTED_SIZE);
        assertEquals("Booking lists match", expectedBookingList, actualBookingList);
    }

    @Test(expected = DoubleBookingException.class)
    public void should_NotDoubleBookHours() throws DoubleBookingException, InvalidBookingException {
        // Arrange
        Booking booking1 = new Booking(10.0, 11.0);
        Booking booking2 = new Booking(10.0, 11.0);

        bookingSystem.book(booking1);

        // Act
        bookingSystem.book(booking2);
    }

    @Test(expected = InvalidBookingException.class)
    @Parameters(method = "invalidBookings")
    public void invalidBookingsTest(double startHour, double endHour) throws DoubleBookingException, InvalidBookingException {
        // Arrange
        Booking booking = new Booking(startHour, endHour);

        // Act
        bookingSystem.book(booking);
    }
}