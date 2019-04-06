package assignments;

import java.util.Scanner;

public class A11dot1 {

    /**
     * Internal class to hold our user input.
     * Because it is internal, we can be a little less
     * formal about getters and setters because we will
     * be the only users of the class. It is private
     * to make sure that nobody else can create and use it.
     * 
     * Since we didn't define any constructors at all, the Java
     * compiler will create a default constructor behind the 
     * scenes for us. It will initiziale the doubles to 0.0,
     * the boolean to false, and the string to null.
     */
    private static class UserInput {
        public double side1;
        public double side2;
        public double side3;
        public String color;
        public boolean isFilled;
    }

    /**
     * Get the user input and store in an object that will let us
     * return all of it at once.
     */
    private static UserInput getUserInput() {
        UserInput userInput = new UserInput();
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the lengths of the three sides of a triangle: ");
            userInput.side1 = scanner.nextDouble();
            userInput.side2 = scanner.nextDouble();
            userInput.side3 = scanner.nextDouble();

            System.out.print("Enter the color: ");
            userInput.color = scanner.next();

            System.out.println("Enter the isFilled property (true or false): ");
            userInput.isFilled = scanner.nextBoolean();
        }

        return userInput;
    }


    /**
     * Determine whether the input data are valid. Note that we don't exit
     * the program from here. The reason is because this method's only job
     * is to determine whether the inputs are valid or not. It doesn't 
     * know about who called it, or what should be done if the inputs
     * are not valid.
     * 
     * This "separation of concerns" is an important principle of software
     * design. If we are defined to do one thing, we should just do that
     * one thing. The code that calls us may have a special reason for 
     * doing so, and we shouldn't make any assumptions about what it 
     * might be.
     * 
     * (We wouldn't even really want any System.out.println() calls in here.
     * We just don't know where we're being called from, so maybe output
     * would be inappropriate. We were just asked to check if the data are
     * valid or not.)
     */
    private static boolean validateInput(UserInput userInput) {
        return userInput.side1 > 0 && userInput.side2 > 0 && userInput.side3 > 0;
    }


    public static void main(String[] argv) {

        // get the input
        UserInput userInput = getUserInput();

        // check for errors
        if (validateInput(userInput) == false) {
            System.err.println("Invalid input");
            System.exit(1);
        }

        // Create our triangle
        Triangle triangle = new Triangle(
            userInput.side1, userInput.side2, userInput.side3,
            userInput.color, userInput.isFilled);

        // print our report
        System.out.printf("The perimeter is: %.4f%n", triangle.getPerimeter());
        System.out.printf("The area is: %.4f%n", triangle.getArea());

        // print our toString() data
        System.out.println();
        System.out.println(triangle.toString());

    }
}