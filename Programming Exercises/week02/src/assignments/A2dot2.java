package assignments;

import java.util.Scanner;

public class A2dot2 {
    
    public static void main(String[] argv) {
        
        // Create the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Prompt for Radius, read it in
            System.out.print("Enter the radius: ");
            double radius = scanner.nextDouble();
            
            // Prompt for length, read it in
            System.out.print("Ender the length: ");
            double length = scanner.nextDouble();
            
            // calculate the area
            double area = Math.PI * radius * radius;
            double volume = area * length;
            
            System.out.printf("The area is %.04f\n", area);
            System.out.printf("The volume is %.04f\n", volume);
        }
    }

}
