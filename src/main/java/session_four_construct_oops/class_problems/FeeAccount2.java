class FeeAccount2
{
    String name;

    FeeAccount(String name)
    {
        this.name = name;
    }
}

class HostelFeeAccount extends FeeAccount
{
    HostelFeeAccount(String name)
    {
        super(name);
    }
}

class PaymentProcessor
{
    int hostelCount = 0;
    int dayScholarCount = 0;

    void processPayment(FeeAccount account, double amount)
    {
        if (account instanceof HostelFeeAccount)
        {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        }
        else
        {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    void printCounts()
    {
        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: "
                + dayScholarCount);
    }
}

public class M5
{
    public static void main(String[] args)
    {
        FeeAccount[] accounts =
        {
            new HostelFeeAccount("Hostel 1"),
            new HostelFeeAccount("Hostel 2"),
            new FeeAccount("Student 3"),
            new FeeAccount("Student 4")
        };

        PaymentProcessor processor = new PaymentProcessor();

        for (int i = 0; i < accounts.length; i++)
        {
            processor.processPayment(accounts[i], 60000);
        }

        processor.printCounts();
    }
}
