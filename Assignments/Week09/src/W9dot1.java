import java.util.Scanner;

/**
 * Test Driver for MyPoint class
 */
public class W9dot1 {

    public static void main(String[] args) {

        System.out.println(
            "This program creates a point at (0,0) and a point at the coordinates \n"
            + "entered by you. It then computes and displays the distance from (0,0)\n"
            + "to the point defined by you, using three different methods.\n");

        try (var scanner = new Scanner(System.in)) {
            MyPoint referencePoint = new MyPoint();

            System.out.print("Enter the x coordinate of a point: ");
            int xCoord = scanner.nextInt();

            System.out.print("Enter the y coordinate of a point: ");
            int yCoord = scanner.nextInt();

            double[] results = new double[3];
            results[0] = referencePoint.distance(xCoord, yCoord);

            MyPoint userPoint = new MyPoint(xCoord, yCoord);

            results[1] = referencePoint.distance(userPoint);
            results[2] = MyPoint.distance(referencePoint, userPoint);

            for (int i = 0; i < results.length; i++) {
                System.out.format(
                    "Using method %d, the distance between %s and %s is %.2f%n", 
                    i + 1,
                    referencePoint.toString(), 
                    userPoint.toString(), 
                    results[i]);
            }

            System.out.println("Farewell...");
        }
    }

}
