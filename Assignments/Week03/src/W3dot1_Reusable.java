
import java.util.Scanner;

/**
 * Implement Programming Exercise 3.5 from the Chapter.
 *
 * (Find future dates) Write a program that prompts the user to enter
 * an integer for today's day of the week (Sunday is 0, Monday is 1, ...,
 * and Saturday is 6). Also prompt the user to enter the number of days
 * after today for a future day and display the future day of the week.
 *
 * Here is a sample run:
 *
 * ```
 * Enter today's day: 1
 * Enter the number of days elapsed since today: 3
 * Today is Monday and the future day is Thursday
 * ```
 *
 * @author kent
 *
 */
public class W3dot1_Reusable {

    public static void main(String[] argv) {

        try (Scanner scanner = new Scanner(System.in)){

            System.out.println(
                    "Given today's day of the week and some number of days in the future\n"
                            + "this program will tell you the day of the week for the future day.");

            // Prompt for inputs and store in variables
            System.out.print("Enter today's day of the week (0 for Sunday, 1 for Monday, etc.): ");
            int today = scanner.nextInt();

            if (today < 0 || today > 6) {
                System.err.println("Invalid weekday. Please enter a number between 0 and 6.");
                System.exit(1);
            }

            System.out.print("Enter the number of days in the future: ");
            int future = scanner.nextInt();

            if (future < 0) {
                System.err.println("Invalid future day. You must enter a positive integer.");
                System.exit(2);
            }

            // Calculate weekday names
            String weekdayToday = getWeekdayName(today);
            String weekdayFuture = getWeekdayName((today + future) % 7);

            // Print them out
            System.out.printf("Today is %s and the future day is %s", weekdayToday, weekdayFuture);

            System.out.println();
            System.out.println("Good-bye.");
        }
    }

    /**
     * Return the name of the week day
     * @param weekday The day of the week (0 = Sunday, 6 = Saturday)
     * @return
     */
    private static String getWeekdayName(int weekday) {
        String name = null;

        switch(weekday) {
            case 0:
                name = "Sunday";
                break;
            case 1:
                name = "Monday";
                break;
            case 2:
                name = "Tuesday";
                break;
            case 3:
                name = "Wednesday";
                break;
            case 4:
                name = "Thursday";
                break;
            case 5:
                name = "Friday";
                break;
            case 6:
                name = "Saturday";
                break;
        }

        return name;
    }

}
