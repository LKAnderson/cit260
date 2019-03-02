/**
 * Class of helpful utilities.
 */
package officehours;

import java.util.Random;

public class Utils {

    private static Random random = new Random();
    
    /**
     * Returns an array of random integers.
     * @param size The number of random integers to return
     * @param maxValue The upper bound for numbers generated
     * @return
     */
    public static int[] getRandomIntegerArray(int size, int maxValue) {

        int[] numbers = new int[size];
        

        for (int i=0; i < size; i++) {
            numbers[i] = random.nextInt(maxValue);
        }

        return numbers;
    }

    /**
     * Return an array with numbers in order starting with the 
     * specified value.
     * @param size The number of integers to generate
     * @param startAt The starting value for the array.
     * @return
     */
    public static int[] getSortedIntegerArray(int size, int startAt) {

        int[] numbers = new int[size];

        for (int i=0; i < size; i++) {
            numbers[i] = startAt + i;
        }

        return numbers;
    }

    
    /**
     * Get random int
     * @param bound
     * @return
     */
    public static int getRandomInt(int bound) {
        return random.nextInt(bound);
    }
    
    
    
    

}