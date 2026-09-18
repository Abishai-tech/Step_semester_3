class LibraryBook
{
    String title;
    String isbn;

    public LibraryBook(String title, String isbn)
    {
        this.title = title;
        if (isbn == null || isbn.equals(""))
            this.isbn = "PENDING";
        else
            this.isbn = isbn;
    }

    public LibraryBook(String title)
    {
        this(title, "PENDING");
    }

    void printStatus()
    {
        System.out.println(title + " | " + isbn + " | Catalogued: true");
    }
}

public class M1
{
    public static void main(String[] args)
    {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++)
        {
            LibraryBook book;

            if (isbns[i].equals(""))
                book = new LibraryBook(titles[i]);
            else
                book = new LibraryBook(titles[i], isbns[i]);

            book.printStatus();
        }
    }
}
