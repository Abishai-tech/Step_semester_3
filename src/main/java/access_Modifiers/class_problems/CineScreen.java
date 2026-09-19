package access_Modifiers.class_problems;

public class CineScreen {
    private final int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0)
            throw new IllegalArgumentException("seatsTotal must be positive");
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        if (seatsAvailable > 0)
            seatsAvailable--;
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal)
            seatsAvailable++;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}
