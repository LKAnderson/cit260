package assignments;

import java.util.Scanner;


/**
 * (Find the number of days in a month) Write a program that prompts 
 * the user to enter the month and year and displays the number of 
 * days in the month. For example, if the user entered month 2 and
 * year 2012, the program should display that February 2012 has 29 
 * days. If the user entered 3 and year 2015, the program should display
 * that March 2015 has 31 days.
 * 
 * 
 * @author kent
 *
 */
public class A3dot11 {
    
    public static void main(String[] argv) {
        
        String[] months = new String[] {
                "January", "February", "March",    "April", "May",    "June",
                "July",    "August", "September", "October", "November", "Decemer"
        };
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Enter the month and year: ");
            int month = scanner.nextInt();
            int year = scanner.nextInt();

            
            if (! (month >= 1 && month <= 12)) {
                System.err.println("Invalid month");
                System.exit(1);
            }
            
            if (year < 0) {
                System.err.println("Year must be positive");
                System.exit(2);;
            }

            // The default case is 31 days
            int days = 31;
            
            // Check for non-default cases
            switch(month) {
            // first the 30-day months
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            // finally, handle poor little February
            case 2:
                if ((year % 4 == 0 && year % 100 != 0)
                    || year % 400 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            }
            
            // Print out the report.
            System.out.printf("%s %d has %d days\n", months[month-1], year, days);
        }
        
    }

}
