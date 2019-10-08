
import java.util.Scanner;

/**
 * (Find the number of days in a month) Write a program that prompts
 * the user to enter the month and year and displays the number of
 * days in the month. For example, if the user entered month 2 and
 * year 2012, the program should display that February 2012 has 29
 * days. If the user entered 3 and year 2015, the program should display
 * that March 2015 has 31 days.
 */
public class W3dot2 {

    public static void main(String[] argv) {

        // Some constants to make things easier
        // to read down below.
        final int FEB = 2;
        final int APR = 4;
        final int JUN = 6;
        final int SEP = 9;
        final int NOV = 11;

        String[] months = new String[] {
                "January", "February", "March",    "April", "May",    "June",
                "July",    "August", "September", "October", "November", "Decemer"
        };

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println(
                "Given a year and a month in that year, this program will tell you\n"
                + "the number of days in that month.");
            System.out.println();

            // prompt for inputs, store in variables

            System.out.print("Enter a year: ");
            int year = scanner.nextInt();

            System.out.print("Enter a value for the month (1=Jan, 2=Feb, etc.): ");
            int month = scanner.nextInt();


            if (! (month >= 1 && month <= 12)) {
                System.err.println("Invalid month");
                System.exit(1);
            }

            if (year < 0) {
                System.err.println("Year must be positive");
                System.exit(2);;
            }

            // Calculate days in the month

            // See if it's leap year. We'll use this in the switch, down below
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) 
                || year % 400 == 0;
            
            // The default case is 31 days
            int days = 31;

            // Check for non-default cases
            switch(month) {
                // first the 30-day months
                case APR:
                case JUN:
                case SEP:
                case NOV:
                    days = 30;
                    break;
                // finally, handle poor little February
                case FEB:
                    if (isLeapYear == true) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                    break;
            }

            // Print out the report.
            System.out.printf("%s %d has %d days\n", months[month-1], year, days);
            System.out.println();
            System.out.println("Good-bye");
        }
    }
}
