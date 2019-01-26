package assignments;

import java.util.Scanner;


public class A2dot5 {
    
    public static void main(String[] argv) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Prompt for the values, both on the same line
            System.out.print("Enter the subtotal and gratuity rate: ");
            double subtotal = scanner.nextDouble();
            double gratuityRate = scanner.nextDouble();
            
            // Calculate the tip and the grand total
            double tip = subtotal * (gratuityRate / 100.0);
            double total = subtotal + tip;
            
            // Print it out
            System.out.printf("The gratuity is $%.02f and total is $%.02f", tip, total);
            
        }
    }

}
