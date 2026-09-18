import java.util.Scanner;

public class PalindromeChecker
{
    static boolean isPalindromeIterative(String text)
    {
        int left = 0;
        int right = text.length() - 1;

        while (left < right)
        {
            if (text.charAt(left) != text.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text)
    {
        if (text.length() <= 1)
            return true;

        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text)
    {
        char arr[] = text.toCharArray();

        for (int i = 0; i < arr.length / 2; i++)
        {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        String reversed = new String(arr);

        return text.equals(reversed);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.nextLine();

        if (isPalindromeIterative(text))
            System.out.println("Iterative: Palindrome");
        else
            System.out.println("Iterative: Not Palindrome");

        if (isPalindromeRecursive(text))
            System.out.println("Recursive: Palindrome");
        else
            System.out.println("Recursive: Not Palindrome");

        if (isPalindromeArrayReversal(text))
            System.out.println("Array Reversal: Palindrome");
        else
            System.out.println("Array Reversal: Not Palindrome");
    }
}
