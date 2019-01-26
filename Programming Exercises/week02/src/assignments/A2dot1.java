package assignments;

import java.util.Scanner;

public class A2dot1 {
    
    public static void main(String[] argv) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Prompt the user
            System.out.print("Enter the degrees in Celsius: ");
            
            // Read the value 
            double celsius = scanner.nextDouble();
            
            // Calculate it
            double fahrenheit = ((9.0/5.0) * celsius) + 32;
            
            // Report it
            System.out.printf("%.01f Celsius is %.01f Fahrenheit", celsius, fahrenheit);
            
        }
        
    }

}
