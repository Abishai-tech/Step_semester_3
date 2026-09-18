class LibraryMember
{
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit)
    {
        if (memberId == null ||
            memberId.trim().length() < 4)
        {
            throw new IllegalArgumentException(
                "Invalid member ID");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook()
    {
        if (booksBorrowed < borrowLimit)
        {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed()
    {
        return booksBorrowed;
    }

    public void displayInfo()
    {
        System.out.println(
            "General Member | Books Borrowed: "
            + booksBorrowed);
    }

    public static String enrollBatch(
        String[] memberIds, int borrowLimit)
    {
        int enrolled = 0;
        int rejected = 0;

        for (int i = 0; i < memberIds.length; i++)
        {
            try
            {
                LibraryMember member =
                    new LibraryMember(
                        memberIds[i], borrowLimit);

                enrolled++;
            }
            catch (IllegalArgumentException e)
            {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled
             + " | Rejected: " + rejected;
    }
}

class StudentMember extends LibraryMember
{
    String course;

    public StudentMember(
        String memberId,
        int borrowLimit,
        String course)
    {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public void displayInfo()
    {
        System.out.println(
            "Student Member | Course: "
            + course
            + " | Books Borrowed: "
            + booksBorrowed);
    }
}

public class M1
{
    public static void main(String[] args)
    {
        StudentMember s =
            new StudentMember("STU10", 3, "CSE");

        s.borrowBook();
        s.borrowBook();

        System.out.println(s.getBooksBorrowed());

        String[] memberIds =
        {
            "STU1",
            "LB1",
            "STU2",
            " ",
            "STU3"
        };

        System.out.println(
            LibraryMember.enrollBatch(memberIds, 3));
    }
}
