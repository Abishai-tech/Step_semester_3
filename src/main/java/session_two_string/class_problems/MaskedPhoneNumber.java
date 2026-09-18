import java.util.Scanner;

public class MaskedPhoneNumber
{
    static String maskPhoneNumber(String phone)
    {
        if (phone.length() != 10)
            return "Invalid phone number";

        for (int i = 0; i < phone.length(); i++)
        {
            if (!Character.isDigit(phone.charAt(i)))
                return "Invalid phone number";
        }

        StringBuilder result = new StringBuilder("XXXXXX");

        result.insert(6, "-");
        result.append(phone.substring(6));

        return result.toString();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));
    }
}
