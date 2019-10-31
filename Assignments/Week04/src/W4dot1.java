
import java.util.Scanner;

/**
 * Convert a hex character to its binary representation.
 */
public class W4dot1 {

    // Could use a switch statement, but arrays are much faster and can
    // be used repeatedly.
    private final static String[] BINARY_DIGITS = new String[] { 
            "0000", // 0
            "0001", // 1
            "0010", // 2
            "0011", // 3
            "0100", // 4
            "0101", // 5
            "0110", // 6
            "0111", // 7
            "1000", // 8
            "1001", // 9
            "1010", // A (10)
            "1011", // B (11)
            "1100", // C (12)
            "1101", // D (13)
            "1110", // E (14)
            "1111", // F (15)
    };

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
                binaryString = BINARY_DIGITS[10 + (hexDigit - 'A')];

            } else if (hexDigit >= '0' && hexDigit <= '9') {
                binaryString = BINARY_DIGITS[hexDigit - '0'];

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
}