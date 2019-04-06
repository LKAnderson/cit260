package assignments;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provide common input methods that can be used by the 
 * exercises for this assignment.
 */
public class UserInput {

    private static Scanner scanner;

    /**
     * Set the input stream to be used by the Scanner object.
     * @param stream The InputStream to use.
     */
    public static void setInputStream(InputStream stream) {
        // If we already had a scanner defined, close it.
        if (scanner != null) {
            scanner.close();
        }

        scanner = new Scanner(stream);
    }

    /**
     * Retrieve an integer value from the user.
     * @param prompt The message to print as a prompt for the user.
     * @return
     */
    public static int getInteger(String prompt) {
        
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.err.println("Invalid integer value");
                // Skip the bad text (scanner won't consume it as an int)
                scanner.next();
                continue;
            }
        }
    }

}