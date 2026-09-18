class ReportMember
{
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    ReportMember(String memberId, int borrowLimit)
    {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        booksBorrowed = 0;
    }

    void borrowBook()
    {
        if (booksBorrowed < borrowLimit)
            booksBorrowed++;
    }

    int getBooksBorrowed()
    {
        return booksBorrowed;
    }

    void displayInfo()
    {
        System.out.print("General | Books: " +
                         booksBorrowed + " | ");
    }
}

class ReportStudent extends ReportMember
{
    private String course;

    ReportStudent(String memberId, int borrowLimit, String course)
    {
        super(memberId, borrowLimit);
        this.course = course;
    }

    String getCourse()
    {
        return course;
    }

    @Override
    void displayInfo()
    {
        System.out.print("Student | Course: " +
                         course + " | Books: " +
                         booksBorrowed + " | ");
    }
}

public class CirculationReport
{
    static String batchPrint(ReportMember[] members)
    {
        StringBuilder report = new StringBuilder();

        for (ReportMember member : members)
        {
            member.displayInfo();

            if (member instanceof ReportStudent)
            {
                ReportStudent student =
                    (ReportStudent) member;

                report.append("Student | Course: ")
                      .append(student.getCourse())
                      .append(" | Books: ")
                      .append(student.getBooksBorrowed())
                      .append(" [Course via downcast: ")
                      .append(student.getCourse())
                      .append("] | ");
            }
            else
            {
                report.append("General | Books: ")
                      .append(member.getBooksBorrowed())
                      .append(" | ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args)
    {
        ReportMember[] members =
        {
            new ReportMember("LB5", 3),
            new ReportStudent("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}
