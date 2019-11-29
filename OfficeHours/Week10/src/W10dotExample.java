import java.util.ArrayList;
import java.util.Scanner;

/**
 * Test Driver for Rectangle and GeometricObject
 */
public class W10dotExample {
    public static void main(String[] args) {

        System.out.println("This program does some stuff.");

        try (var scanner = new Scanner(System.in)) {
            var objects = new ArrayList<GeometricObject>();

            for (int i=1; i <= 3; i++) {
                var rect = readRectangleFromUser(i, scanner);
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
    public static Rectangle readRectangleFromUser(int shapeNumber, Scanner scanner) {
        System.out.format("Entering Rectangle #%d...%n", shapeNumber);
        System.out.print("Please enter a color: ");

        String color = scanner.nextLine().trim();
        if (color.length() == 0) {
            System.err.println("Please enter a color");
            return null;
        }

        System.out.print("Is the rectangle filled (true/false)? ");
        boolean filled = scanner.nextBoolean();

        System.out.print("Enter the length and width: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        scanner.skip("\n");

        if (length <= 0 || width <= 0) {
            System.err.println("Please enter value dimensions");
            return null;
        }

        Rectangle newRect = new Rectangle(length, width, color, filled);

        return newRect;
    }

}
