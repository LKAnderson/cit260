package officehours;

import java.util.Scanner;

/**
 * Calculates the volume of a Cylinder
 * @author kent
 *
 */
public class A2dot2 {
    
    
    
    public static void main(String[] args) {
        
        // prompt for radius and length
        System.out.print("Enter the radius and length of a cylinder: ");
        
        // read in the values
        try (Scanner scanner = new Scanner(System.in)) {
            
            double radius = scanner.nextDouble();
            double length = scanner.nextDouble();
            
            // calculate the area PI * r^2
            double area = Math.PI * radius * radius;
            
            
            // calculate the volume
            double volume = area * length;
            
            // report the results
            System.out.printf("The area is %.02f\n", area);
            System.out.printf("The volume is %.02f\n", volume);
        }
        
        
    }

}


