import java.util.ArrayList;
import java.util.Scanner;

/**
 * Test Driver for Rectangle and GeometricObject
 */
public class W10dot1 {
    public static void main(String[] args) {

        System.out.println("This program does some stuff.");

        try (var scanner = new Scanner(System.in)) {
            var objects = new ArrayList<GeometricObject>();

            for (int i=1; i <= 3; i++) {
                var rect = readTriangleFromUser(i, scanner);
                if (rect == null) {
                    System.exit(1);
                }

                objects.add(rect);
            }

            for (GeometricObject obj: objects) {
                System.out.println();
                System.out.println(obj.toString());
                System.out.format("The area is: %.2f\n", obj.getArea());
            }
        }

    }

    /**
     * Gets a Rectangle object from the user.
     * @param shapeNumber
     * @param scanner
     * @return The rectangle, or null if invalid data was entered (an error message is already printed)
     */
    public static Triangle readTriangleFromUser(int shapeNumber, Scanner scanner) {
        System.out.format("Entering Triangle #%d...%n", shapeNumber);
        System.out.print("Please enter a color: ");

        scanner.reset();

        String color = scanner.nextLine().trim();
        if (color.length() == 0) {
            System.err.println("Please enter a color");
            return null;
        }

        System.out.print("Is the rectangle filled (true/false)? ");
        boolean filled = scanner.nextBoolean();

        System.out.print("Enter the lengths of the three sides: ");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();

        // Finish reading the line of text, if there's one there.
        scanner.nextLine();

        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            System.err.println("Please enter value lengths for the sides");
            return null;
        }

        Triangle triangle = new Triangle(side1, side2, side3, color, filled);

        return triangle;
    }

}
