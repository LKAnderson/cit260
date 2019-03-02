package officehours;

/**
 * Demonstrate the BubbleSort algorithm.
 * @author kent
 *
 */
public class BubbleSortDemo {
    
    public static void main(String[] argv) {
        
        int[] numbers = Utils.getRandomIntegerArray(20, 100);
        
        for (int outer=0; outer < numbers.length; outer++) {
            
            for (int inner=outer+1; inner < numbers.length; inner++) {
                
                if (numbers[inner] < numbers[outer]) {
                    int tmp = numbers[outer];
                    numbers[outer] = numbers[inner];
                    numbers[inner] = tmp;
                }
                
            }
        }
        
    }

}
