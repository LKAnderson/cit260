package officehours;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListCreator {
    
    
    public static void main(String[] argv) {
        
        ArrayList<Double> values = new ArrayList<Double>();
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Please enter any number of numbers: ");
            
            while (scanner.hasNextDouble()) {
                values.add(scanner.nextDouble());
            }
        }
        
        // Now I have a collection of 5 spots to put double values in.
        
        for (double value : values) {
            System.out.println(value);
        }
        
        
    }

}
