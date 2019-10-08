import java.util.Scanner;

/**
 * Convert celsius to fahrenheight
 */
public class W2dot1 {
    public static void main(String[] argv) {

        // Open a scanner using the keyboard as input. Close it when
        // the program ends.
        try (var scanner = new Scanner(System.in)) {

            // Description
            System.out.println("This program converts celsius to fahrenheit.\n");

            // Prompt for input
            System.out.print("Enter a temperature in celsius: ");
            var celsius = scanner.nextDouble();

            // Convert to F
            var fahrenheit = ((9.0/5.0) * celsius) + 32.0;

            // Print report
            System.out.format("%.02fC is %.02fF\n", celsius, fahrenheit);
            System.out.println("Good-bye.");
        }

    }
}
