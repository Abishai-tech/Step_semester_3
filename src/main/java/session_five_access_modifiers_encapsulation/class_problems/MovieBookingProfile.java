class MovieBookingProfile
{
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile()
    {
        name = "";
        confirmed = false;
    }

    public MovieBookingProfile(String name)
    {
        this();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed)
    {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp)
    {
        if (otp != null &&
            otp.matches("[0-9]{4,6}"))
        {
            this.otp = otp;
        }
    }
}

public class M4
{
    public static void main(String[] args)
    {
        MovieBookingProfile p =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(p.getName());

        p.setConfirmed(true);

        System.out.println(p.isConfirmed());

        p.setOtp("4471");
    }
}
