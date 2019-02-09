package assignments;

public class A5dot3 {

    public static void main(String[] argv) {
        
        // print the table headers (alignment matters)
        System.out.printf("%9s     %6s\n", "Kilograms", "Pounds");
        
        // loop with a counter of only the odd
        // numbers between 1 and 199.
        for(int kilograms = 1; kilograms <= 199; kilograms += 2) {
        
            // Convert the kilograms to pounds (1 kg = 2.2 lbs)
            double pounds = kilograms * 2.2;
        
            // Print the formatted table
            System.out.printf("%-9d     %6.1f\n", kilograms, pounds);
        }
    }
    
    
}
