package access_Modifiers.class_problems;

public class PremiumMovieTicket extends MovieTicket {
    public PremiumMovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
        super(seatNumber, screenId, ticketPrice, movieTitle);
    }

    public double getOwnTypeTicketPrice() {
        return ticketPrice;
    }
}
