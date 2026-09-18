import java.util.Scanner;

public class BMICalculator
{
    static String getBmiStatus(double bmi)
    {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double heights[], double weights[])
    {
        System.out.println();
        System.out.println("WELLNESS REPORT");
        System.out.println("-----------------------------------------------");

        System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
                          "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++)
        {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                              i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        double heights[] = new double[5];
        double weights[] = new double[5];

        for (int i = 0; i < 5; i++)
        {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter height in meters: ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight in kg: ");
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);
    }
}
