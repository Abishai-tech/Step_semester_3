final class BookingReceipt
{
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers)
    {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    public String[] getSeatNumbers()
    {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(
        int index, String newSeat)
    {
        String[] newSeats = seatNumbers.clone();

        if (index >= 0 && index < newSeats.length)
        {
            newSeats[index] = newSeat;
        }

        return new BookingReceipt(bookingId, newSeats);
    }
}

class GroupBookingReceipt extends BookingReceipt
{
    private int groupSize;

    public GroupBookingReceipt(
        String bookingId,
        String[] seatNumbers,
        int groupSize)
    {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}

public class M5
{
    static String processNightlySettlement(
        BookingReceipt[] receipts)
    {
        int processed = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (int i = 0; i < receipts.length; i++)
        {
            if (receipts[i] == null)
            {
                nullCount++;
            }
            else
            {
                processed++;

                if (receipts[i] instanceof GroupBookingReceipt)
                {
                    groupCount++;
                }
                else
                {
                    individualCount++;
                }
            }
        }

        return processed + " processed | "
             + nullCount + " null skipped | "
             + groupCount + " group | "
             + individualCount + " individual";
    }

    public static void main(String[] args)
    {
        BookingReceipt b =
            new BookingReceipt(
                "CH-1001",
                new String[]{"A1", "A2"});

        String[] seats = b.getSeatNumbers();
        seats[0] = "X";

        System.out.println(b.getSeatNumbers()[0]);

        BookingReceipt updated =
            b.withUpdatedSeat(1, "A3");

        System.out.println(b.getSeatNumbers()[0]
                           + ", " + b.getSeatNumbers()[1]);

        System.out.println(updated.getSeatNumbers()[0]
                           + ", " + updated.getSeatNumbers()[1]);

        BookingReceipt[] receipts =
        {
            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2),

            null,

            new BookingReceipt(
                "CH-3003",
                new String[]{"C1"})
        };

        System.out.println(
            processNightlySettlement(receipts));
    }
}
