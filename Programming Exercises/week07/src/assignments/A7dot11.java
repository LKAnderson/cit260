package assignments;

import java.util.Scanner;

public class A7dot11 {

    
    public static double[] getDoubles(String[] inputs) {
        
        double[] doubles = new double[inputs.length];
        
        for (int i=0; i < inputs.length; i++) {
            try {
                doubles[i] = Double.parseDouble(inputs[i]); 
            } catch (NumberFormatException exception) {
                doubles[i] = 0;
            }
        }
        
        return doubles;
        
    }
    
    
    public static double mean(double[] data) {
        double total = 0;
        for (double d: data) {
            total += d;
        }
        return total / data.length;
    }
    
    
    public static double deviation(double[] data) {
        double mean = mean(data);
        
        double sumDeviation = 0;
        for (double d: data) {
            sumDeviation += Math.pow(d - mean, 2);
        }
        
        return Math.sqrt(sumDeviation / (data.length-1));
    }
    
    
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)){
            
            System.out.print("Enter the numbers: ");
            String input = scanner.nextLine();
            
            String[] inputs = input.split("\\s+");
            double[] doubles = getDoubles(inputs);
            
            System.out.printf("The mean is %.2f%n", mean(doubles));
            System.out.printf("The standard deviation is %.5f%n", deviation(doubles));
        }
    }
    
}

