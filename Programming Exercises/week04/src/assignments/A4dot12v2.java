package assignments;

import java.util.Scanner;

/**
 * Convert a hex character to its binary representation.
 */
public class A4dot12v2 {


    public static void main(String[] argv) {

        try (Scanner scanner = new Scanner(System.in)) {

            // prompt the user for the hex digit.
            System.out.print("Enter a hex digit: ");
            String hexString = scanner.nextLine().trim();
            hexString = hexString.toUpperCase();

            // Make sure they only entered a single digit.
            if (hexString.length() != 1) {
                if (hexString.length() == 0) {
                    hexString = "<empty>";
                }

                System.err.println(hexString + " is an invalid input");
                System.exit(1);
            }

            // Get the first (only) character
            char hexDigit = hexString.charAt(0);
            int digit = 0;

            // Find the binary string according to the relative offset
            // of the character from its root character.
            if (hexDigit >= 'A' && hexDigit <= 'F') {
                digit = 10 + (hexDigit - 'A');

            } else if (hexDigit >= '0' && hexDigit <= '9') {
                digit = hexDigit - '0';

            } else {
                System.err.printf("%c is an invalid input\n", hexDigit);
                // Exiting the whole program from an if-else-if ladder
                // isn't really the best form, but it will do for this
                // lesson.
                System.exit(1);
            }

            String binaryString = Integer.toBinaryString(digit);
            
            // Make sure it's four digits
            if (binaryString.length() == 1) {
                binaryString = "0" + binaryString;
            }
            
            // notice the *lack* of an else here. We want each
            // if statement to be tested as we build up our
            // string to 4 digits.
            
            if (binaryString.length() == 2) {
                binaryString = "0" + binaryString;
            }
            
            if (binaryString.length() == 3) {
                binaryString = "0" + binaryString;
            }
            // Man! I can't wait until we learn about loops
            // next week!
            
            // Print it out.
            System.out.printf("The binary value is %s\n", binaryString);
                    
        }
    }
}