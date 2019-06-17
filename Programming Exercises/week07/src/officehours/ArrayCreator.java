package officehours;

import java.util.Scanner;

public class ArrayCreator {
    
    
    public static void main(String[] argv) {
        
        double[] values = new double[5];
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Please enter any number of numbers: ");
            
            int count = 0;
            while(count < values.length) {
                
                if (scanner.hasNextDouble() == false) {
                    //System.err.println("Please enter valid numbers!");
                    //System.exit(1);
                    break;
                }
                
                values[count] = scanner.nextDouble();
                count += 1;
                
                if (count == values.length) {
                    double[] newValues = new double[values.length * 2];
                    
                    for (int i = 0; i < count; i++) {
                        newValues[i] = values[i];
                    }
                    
                    values = newValues;
                }
            }
            
        }
        
        
        // Now I have a collection of 5 spots to put double values in.
        
        for (double value : values) {
            System.out.println(value);
        }
        
        
    }

}
