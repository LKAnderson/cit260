package officehours;

import java.util.Scanner;

public class A11dot934 {

    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in) ) {

            System.out.print("Enter width, height, color, filled: ");
            double width = scanner.nextDouble();
            double height = scanner.nextDouble();
            String color = scanner.next();
            boolean filled = scanner.nextBoolean();

            var rectangle = new Rectangle(width, height, color, filled);
            System.out.println("The area of the rectangle is " + rectangle.getArea());
            System.out.println("The perimeter of the rectangle is " + rectangle.getPerimeter());
            System.out.println();
            System.out.println(rectangle.toString());

        }

    }
}