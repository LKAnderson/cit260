package officehours;

import java.util.Random;

/**
 * Demonstrate a binary search using a recursive method.
 * @author kent
 *
 */
public class BinarySearchRecursive {

    /**
     * Perform a binary search for the number in the given array.
     * @param numberToFind
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int numberToFind, int[] array, int low, int high) {

        if (high < low) {
            return -1;
        } 
        
        int index = (low + high) / 2;

        if (array[index] == numberToFind) {
            return index;
            
        } else if (numberToFind < array[index]) {
            return binarySearch(numberToFind, array, low, index-1);
            
        } else {
            return binarySearch(numberToFind, array, index+1, high);
            
        }
    }
    
    
    
    

    public static void main(String[] argv) {

        int[] numbers = Utils.getSortedIntegerArray(20, 0);
        int numberToFind = 17; //random.nextInt(20);

        int foundPosition = binarySearch(numberToFind, numbers, 0, numbers.length - 1);

        if (foundPosition >= 0) {
            System.out.printf("%d is found at position %d%n", numberToFind, foundPosition);
        } else {
            System.out.printf("%d is not found in the set of numbers.%n", numberToFind);
        }
    }

}