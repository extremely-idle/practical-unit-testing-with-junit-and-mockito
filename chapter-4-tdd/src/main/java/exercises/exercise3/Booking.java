package exercises.exercise3;

import java.util.Objects;

public class Booking {
    private double startHour;
    private double endHour;

    public Booking(double startHour, double endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public double getStartHour() {
        return startHour;
    }

    public double getEndHour() {
        return endHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return startHour == booking.startHour &&
                endHour == booking.endHour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startHour, endHour);
    }
}