/**
 * Write a program that prompts the user for a year and
 * reports whether the year is a leap year or not.
 */

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        try (var input = new Scanner(System.in)) {
            // prompt user for a year
            System.out.print("Enter a year: ");
            var year = input.nextInt();

            // check for valid year
            if (year <= 0) {
                System.err.println("Year must be greater than 0");
                System.exit(0);
            }

            // Calculate if it is leap year
            // Divisible by 4 but not by 100, or divisible by 400
            boolean isLeapYear = false;

            boolean condition1 = (year % 4 == 0 && year % 100 != 0);
            boolean condition2 = year % 400 == 0;
            if ( condition1 == true || condition2 == true) {
                isLeapYear = true;
            }

            // Print out result
            if (isLeapYear == true) {
                System.out.format("%d is a leap year", year);
            } else {
                System.out.format("%d is NOT a leap year", year);
            }
        }

    }
}
