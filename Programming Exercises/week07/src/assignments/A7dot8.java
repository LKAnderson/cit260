package assignments;

import java.util.Scanner;

/**
 * Calculating averages of ints and doubles
 * @author kent
 */
public class A7dot8 {
    
    // Constants that help drive the program
    public static final String INT = "INT";
    public static final String DOUBLE = "DOUBLE";
    public static final String QUIT = "QUIT";
    
    /**
     * Calculate the average of the integers provided.
     * @param numbers
     * @return
     */
    public static int average(int[] numbers) {
        
        // loop through all elements and total the values
        int total = 0;
        for (int number: numbers) {
            total += number;
        }
        
        // divide the total by the number of elements.
        return total / numbers.length;
    }
    
    /**
     * Calculate the aver of the doubles provided.
     * @param numbers
     * @return
     */
    public static double average(double[] numbers) {
        
        // loop through all elements and total the values
        double total = 0;
        for (double number: numbers) {
            total += number;
        }
        
        // divide the total by the number of elements
        return total / numbers.length;
    }
    
    /**
     * Convert the user's input into an array of integers
     * @param inputs
     * @return
     */
    public static int[] parseIntegerInput(String[] inputs) {
        
        // create the int[] to hold the converted values
        int[] integers = new int[inputs.length];
        
        // loop through all elements of the input array and convert them
        // to int's.
        for (int i=0; i < inputs.length; i++ ) {
            try {
                integers[i] = Integer.parseInt(inputs[i]);
            } catch (NumberFormatException exception) {
                integers[i] = 0;
            }
        }
        
        return integers;
    }
    
    /**
     * Convert the user's input into an array of doubles
     * @param inputs
     * @return
     */
    public static double[] parseDoubleInput(String[] inputs) {
        
        // create the int[] to hold the converted values
        double[] doubles = new double[inputs.length];
        
        // loop through all elements of the input array and convert them
        // to int's.
        for (int i=0; i < inputs.length; i++ ) {
            try {
                doubles[i] = Double.parseDouble(inputs[i]);
            } catch (NumberFormatException exception) {
                doubles[i] = 0;
            }
        }
        
        return doubles;
    }
 
    /**
     * Prompt the user for the data type they will be entering.
     * @param scanner
     * @return
     */
    public static String getDataType(Scanner scanner) {
        
        String choice = "";
        boolean valid = false;
        
        
        // Loop until the user gives us a valid choice.
        while (valid == false) {
            
            System.out.print("Enter the type of data (int, double, or quit): ");
            choice = scanner.nextLine().toUpperCase();
            
            switch (choice) {
                case INT:
                case DOUBLE:
                case QUIT:
                    valid = true;
                    break;
                    
                default:
                    valid = false;
            }
        }
        
        return choice;
    }
    
    /**
     * Get the user's input for the numbers they will be averaging.
     * @param scanner
     * @param dataType
     * @return
     */
    public static String[] getData(Scanner scanner, String dataType) {
        
        // Prompt the user
        System.out.printf("Enter the %s values (separated by spaces):", dataType);
        
        // Read the data from the line entered by the user
        String line = scanner.nextLine();
        
        // Split it into individual array elements based on whitespace (regex)
        String[] data = line.split("\\s+");
        
        return data;
    }
    
    
    /**
     * The main method of the program.
     * @param args
     */
    public static void main(String[] args) {
 
        try (Scanner scanner = new Scanner(System.in)) {
        
            // Loop until the user enters "QUIT"
            while (true) {
                
                String choice = getDataType(scanner);
                
                // Check if they want to quit.
                if (choice.equals(QUIT)) {
                    break;
                }
                
                // Read their data values
                String[] data = getData(scanner, choice);
                
                // Get the average
                if (choice.equals(INT)) {
                    int[] intData = parseIntegerInput(data);
                    System.out.printf("The average is %d%n", average(intData));
                    
                } else if (choice.equals(DOUBLE)) {
                    double[] doubleData = parseDoubleInput(data);
                    System.out.printf("The average is %.3f%n", average(doubleData));
                }
                
            }
            
        }
        
        System.out.println("Thank you!");
    }
}
