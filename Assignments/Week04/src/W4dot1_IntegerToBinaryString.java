
import java.util.Scanner;

/**
 * Convert a hex character to its binary representation.
 */
public class W4dot1_IntegerToBinaryString {

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

            // default to an empty string
            String binaryString = "";

            // Find the binary string according to the relative offset
            // of the character from its root character.
            if (hexDigit >= 'A' && hexDigit <= 'F') {
                binaryString = Integer.toBinaryString(10 + (hexDigit - 'A'));

            } else if (hexDigit >= '0' && hexDigit <= '9') {
                binaryString = Integer.toBinaryString(hexDigit - '0');

            } else {
                System.err.printf("%c is an invalid input%n", hexDigit);
                // Exiting the whole program from an if-else-if ladder
                // isn't really the best form, but it will do for this
                // lesson.
                System.exit(1);
            }

            // Make sure the string is 4 digits
            binaryString = "0".repeat(4 - binaryString.length()) + binaryString;

            // Print it out.
            System.out.printf("The binary value is %s%n", binaryString);
        }
    }
}