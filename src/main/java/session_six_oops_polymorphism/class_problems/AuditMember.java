class AuditMember
{
    public final String memberNumber;

    private static int counter = 100;
    private static int membersEnrolled = 0;

    protected int borrowLimit;
    protected int booksBorrowed;

    AuditMember(int borrowLimit)
    {
        this.borrowLimit = borrowLimit;
        booksBorrowed = 0;

        counter++;
        memberNumber = "LIB-" + counter;

        membersEnrolled++;
    }

    void borrowBook()
    {
        if (booksBorrowed < borrowLimit)
            booksBorrowed++;
    }

    void borrowBook(String genre)
    {
        System.out.println("Genre: " + genre);
        borrowBook();
    }

    int getBooksBorrowed()
    {
        return booksBorrowed;
    }

    static boolean isValidRenewalCode(String code)
    {
        if (code == null || code.length() != 4)
            return false;

        if (code.charAt(0) != 'R')
            return false;

        if (!Character.isDigit(code.charAt(1)))
            return false;

        if (!Character.isDigit(code.charAt(2)))
            return false;

        if (!Character.isUpperCase(code.charAt(3)))
            return false;

        return true;
    }

    static int getMembersEnrolled()
    {
        return membersEnrolled;
    }
}

class AuditFaculty extends AuditMember
{
    private String department;

    AuditFaculty(int borrowLimit, String department)
    {
        super(borrowLimit);
        this.department = department;
    }
}

public class NightlyAuditTest
{
    static String processNightlyAudit(AuditMember[] members)
    {
        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (AuditMember member : members)
        {
            if (member == null)
            {
                nullSkipped++;
            }
            else
            {
                processed++;

                if (member instanceof AuditFaculty)
                    faculty++;
                else
                    regular++;
            }
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               faculty + " faculty | " +
               regular + " regular";
    }

    public static void main(String[] args)
    {
        AuditMember m1 = new AuditMember(3);

        System.out.println(m1.memberNumber);
        System.out.println(AuditMember.getMembersEnrolled());

        System.out.println(
            AuditMember.isValidRenewalCode("R12A"));

        System.out.println(
            AuditMember.isValidRenewalCode("R1A"));

        System.out.println(
            AuditMember.isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(m1.getBooksBorrowed());

        AuditMember[] members =
        {
            new AuditFaculty(5, "Physics"),
            null,
            new AuditMember(3)
        };

        System.out.println(
            processNightlyAudit(members));
    }
}
