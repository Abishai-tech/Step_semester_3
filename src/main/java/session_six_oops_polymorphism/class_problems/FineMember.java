class FineMember
{
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    protected void chargeFine(int amount)
    {
        if (amount <= 0)
            return;

        if (fineCount < 10)
        {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    int[] getFineHistory()
    {
        int[] copy = new int[fineCount];

        for (int i = 0; i < fineCount; i++)
        {
            copy[i] = fineHistory[i];
        }

        return copy;
    }

    int getTotalFine()
    {
        int total = 0;

        for (int i = 0; i < fineCount; i++)
        {
            total += fineHistory[i];
        }

        return total;
    }
}

class DiscountStudent extends FineMember
{
    @Override
    protected void chargeFine(int amount)
    {
        super.chargeFine(amount / 2);
    }
}

public class FineLedgerTest
{
    public static void main(String[] args)
    {
        DiscountStudent student = new DiscountStudent();

        student.chargeFine(100);

        System.out.println("Total Fine: " +
                           student.getTotalFine());

        int[] history = student.getFineHistory();

        history[0] = 999;

        System.out.println("Actual Fine: " +
                           student.getFineHistory()[0]);
    }
}
