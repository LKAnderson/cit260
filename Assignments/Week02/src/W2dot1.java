import java.util.Scanner;

public class W2dot1 {
    public static void main(String[] argv) {

        try (var scanner = new Scanner(System.in)) {

            System.out.println("This program converts celsius to fahrenheit.\n");
            System.out.print("Enter a temperature in celsius: ");

            var celsius = scanner.nextDouble();

            var fahrenheit = ((9.0/5.0) * celsius) + 32.0;

            System.out.format("%.02fC is %.02fF\n", celsius, fahrenheit);
            System.out.println("Good-bye.");
        }

    }
}
