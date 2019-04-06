package assignments;

import java.util.Random;


public class A12dot3 {

    public static void main(String[] argv) {
        
        // Create the random ints
        int[] integers = new int[100];
        Random random = new Random();
        for (int i=0; i < integers.length; i++) {
            integers[i] = random.nextInt();
        }

        // Prompt for the index
        UserInput.setInputStream(System.in);
        int index = UserInput.getInteger("Enter an index: ");

        // Print the value at the index, or handle the 
        // ArrayIndexOutOfBounds exception
        try {
            System.out.printf("The random value at index %d is %d%n", 
                index, integers[index]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println("Out of Bounds");
        }
    }

}