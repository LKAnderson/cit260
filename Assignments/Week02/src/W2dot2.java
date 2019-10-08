import java.util.Scanner;

/**
 * Create a tax+tip calculator. Print all of the details of the transaction.
 */
public class W2dot2 {

    /**
     * The tax rate to be applied to the transaction.
     */
    private static final double TAX_RATE = 0.032;

    public static void main(String[] argv) {

        // Open a scanner using the keyboard as input. Close it automatically
        // at the end of the program.
        try (var scanner = new Scanner(System.in)) {

            // Description
            System.out.println("This is a tax + tip calculator.\n");

            // Prompt and gather inputs.
            System.out.print("Enter the meal cost: ");
            var cost = scanner.nextDouble();

            System.out.print("Enter the tip percentage: ");
            var tipRate = scanner.nextDouble() * 0.01;

            // calculate the tip and tax.
            var tip = cost * tipRate;
            var tax = cost * TAX_RATE;

            // total it all
            var total = cost + tip + tax;

            // Print the report
            System.out.format("The tip is $%.02f\n", tip);
            System.out.format("The tax is $%.02f\n", tax);
            System.out.format("The total is $%.02f\n", total);
            System.out.println("Good-bye");
        }
    }
}
