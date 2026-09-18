class MovieTicket
{
    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;

    MovieTicket(String seatNumber, String screenId,
                double ticketPrice, String movieTitle)
    {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }
}

public class M1
{
    static String classifyAccess(String fieldModifier,
                                 String accessorContext)
    {
        if (fieldModifier.equals("public"))
            return "ALLOWED";

        if (fieldModifier.equals("private"))
        {
            if (accessorContext.equals("SAME_CLASS"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (fieldModifier.equals("default"))
        {
            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (fieldModifier.equals("protected"))
        {
            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts)
    {
        int allowed = 0;
        int denied = 0;

        for (int i = 0; i < attempts.length; i++)
        {
            String result =
                classifyAccess(attempts[i][0], attempts[i][1]);

            if (result.equals("ALLOWED"))
                allowed++;
            else
                denied++;
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args)
    {
        System.out.println(
            classifyAccess("private", "SAME_CLASS"));

        System.out.println(
            classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] attempts =
        {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeBatch(attempts));
    }
}
