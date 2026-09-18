class PlacementRecord
{
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa)
    {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord()
    {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class M1
{
    public static void main(String[] args)
    {
        PlacementRecord p1 = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord p2 = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord p3 = new PlacementRecord("Karthik", "Infosys", 4.0);

        PlacementRecord[] records = {p1, p2, p3};

        for (int i = 0; i < records.length; i++)
        {
            records[i].printRecord();
        }
    }
}
