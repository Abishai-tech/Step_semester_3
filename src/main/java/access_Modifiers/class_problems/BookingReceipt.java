package access_Modifiers.class_problems;

public class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] seats = seatNumbers.clone();
        seats[index] = newSeat;
        return new BookingReceipt(bookingId, seats);
    }

    public String getBookingId() {
        return bookingId;
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, skipped = 0, group = 0, individual = 0;

        for (BookingReceipt receipt : receipts) {
            if (receipt == null) {
                skipped++;
            } else {
                processed++;
                if (receipt instanceof GroupBookingReceipt)
                    group++;
                else
                    individual++;
            }
        }

        return processed + " processed | " + skipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}
