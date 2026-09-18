class LibraryMember2
{
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember2(
        String memberId, int borrowLimit)
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
}

class StudentMember extends LibraryMember2
{
    protected String course;

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

class HonorsStudentMember extends StudentMember2
{
    int bonusLimit;

    public HonorsStudentMember(
        String memberId,
        int borrowLimit,
        String course,
        int bonusLimit)
    {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    public void displayInfo()
    {
        System.out.println(
            "Honors Student Member | Course: "
            + course
            + " | Bonus Limit: "
            + bonusLimit
            + " | Books Borrowed: "
            + booksBorrowed);
    }
}

class FacultyMember extends LibraryMember2
{
    String department;

    public FacultyMember(
        String memberId,
        int borrowLimit,
        String department)
    {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public void displayInfo()
    {
        System.out.println(
            "Faculty Member | Department: "
            + department
            + " | Books Borrowed: "
            + booksBorrowed);
    }
}

public class M2
{
    static String classifyGeneration(
        LibraryMember2 member)
    {
        if (member instanceof HonorsStudentMember)
        {
            return "Multilevel descendant (3 generations deep)";
        }
        else if (member instanceof FacultyMember)
        {
            return "Hierarchical sibling (independent branch)";
        }
        else if (member instanceof StudentMember)
        {
            return "Student branch";
        }
        else
        {
            return "General Member";
        }
    }

    static int getTotalBooksBorrowed(
        LibraryMember2[] members)
    {
        int total = 0;

        for (int i = 0; i < members.length; i++)
        {
            total = total + members[i].getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args)
    {
        LibraryMember2 general =
            new LibraryMember2("STU1", 3);

        StudentMember student =
            new StudentMember("STU2", 3, "CSE");

        HonorsStudentMember honors =
            new HonorsStudentMember(
                "STU3", 3, "ECE", 2);

        FacultyMember faculty =
            new FacultyMember(
                "STU4", 5, "Physics");

        general.displayInfo();
        student.displayInfo();
        honors.displayInfo();
        faculty.displayInfo();

        System.out.println(
            classifyGeneration(honors));

        System.out.println(
            classifyGeneration(faculty));

        LibraryMember2[] members =
        {
            student,
            honors,
            faculty
        };

        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        System.out.println(
            getTotalBooksBorrowed(members));
    }
}
