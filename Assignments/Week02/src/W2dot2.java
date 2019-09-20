import java.util.Scanner;

public class W2dot2 {

    private static final double TAX_RATE = 0.032;

    public static void main(String[] argv) {

        try (var scanner = new Scanner(System.in)) {

            System.out.println("This is a tax + tip calculator.\n");

            System.out.print("Enter the meal cost: ");
            var cost = scanner.nextDouble();

            System.out.print("Enter the tip percentage: ");
            var tipRate = scanner.nextDouble() * 0.01;

            var tip = cost * tipRate;
            var tax = cost * TAX_RATE;

            var total = cost + tip + tax;

            System.out.format("The tip is $%.02f\n", tip);
            System.out.format("The tax is $%.02f\n", tax);
            System.out.format("The total is $%.02f\n", total);
            System.out.println("Good-bye");
        }
    }
}
