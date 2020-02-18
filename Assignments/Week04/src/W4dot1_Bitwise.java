
import java.util.Scanner;

/**
 * Convert a hex character to its binary representation.
 */
public class W4dot1_Bitwise {

    public static void main(final String[] argv) {

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
            final char hexDigit = hexString.charAt(0);

            // default to an empty string
            String binaryString = "";

            // Find the binary string according to the relative offset
            // of the character from its root character.
            if (hexDigit >= 'A' && hexDigit <= 'F') {
                binaryString = getBinaryString(10 + (hexDigit - 'A'));

            } else if (hexDigit >= '0' && hexDigit <= '9') {
                binaryString = getBinaryString(hexDigit - '0');

            } else {
                System.err.printf("%c is an invalid input%n", hexDigit);
                // Exiting the whole program from an if-else-if ladder
                // isn't really the best form, but it will do for this
                // lesson.
                System.exit(1);
            }

            // Print it out.
            System.out.printf("The binary value is %s%n", binaryString);
        }
    }

    /**
     * Build a binary string using bitwise shifting and operators
     * 
     * @param ch The value to convert to a binary string.
     */
    private static String getBinaryString(final int ch) {

        // Use a StringBuilder so we don't have to waste
        // memory concatenating strings.
        StringBuilder binaryString = new StringBuilder();

        // Loop through bits 0 through 4
        for (int i = 0; i < 4; i++) {

            // Shift the bit so that it is in position 0
            // then AND it with 1. If the bit is 1, 
            // then 1 & 1 = 1. Otherwise 1 & 0 = 0.
            binaryString.append((ch >> i) & 1);
        }

        // We built it in reverse, so reverse it
        // to put it in the correct order.
        return binaryString.reverse().toString();
    }
}