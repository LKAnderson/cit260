/**
 * Calculate the amount saved to retirement from a monthly paycheck.
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class W2dot1 {

    public static void main(String[] args) {

        // <Variable type, or "var"> <variableName> [ = <initial value>]

        //var input = new Scanner(System.in);
        try (var input = new Scanner(System.in)) {

            // Print a description of the application
            System.out.println(
                    "This program calculates the retirement savings contribution"
                            + " that should be made for a month’s pay.");
            System.out.println();

            // Prompt the user the for monthly salary amount.
            System.out.print("Enter the monthly gross pay: ");

            // Read salary into a variable
            double salary = input.nextDouble();

            // Prompt the user for the saving percentage
            System.out.print("Enter the percentage to save: ");

            // Read percentage into a variable
            double percent = input.nextDouble();

            // Convert percentage to a fractional value
            percent = percent / 100.0;

            // Calculate the amount to save as salary * percentage
            double savingsAmount = salary * percent;

            // Print the savings amount to the screen
            System.out.println();
            System.out.format("The amount to put into the savings account is $%.2f  %n", savingsAmount);

            DecimalFormat df = new DecimalFormat("$#,##0.00");
            System.out.println("The amount to put into the savings account is " + df.format(savingsAmount));

        }
        //input.close();
    }
}
