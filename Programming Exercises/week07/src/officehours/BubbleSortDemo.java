package officehours;

/**
 * Demonstrate the BubbleSort algorithm.
 * 
 * @author kent
 *
 */
public class BubbleSortDemo {

    public static void main(String[] argv) {

        // Generate 20 random integers
        int[] numbers = Utils.getRandomIntegerArray(20, 100);

        // Yes, we could just call this...
        //
        // Arrays.sort(numbers);
        //
        // But we wouldn't learn much about arrays and thinking
        // through algorithms if we did that.

        // Walk the array, one by one. We're going to compare each
        // element of the array to every other element in the array
        // after it. The result will be that at the end of each
        // iteration of this outer loop, the smallest number in the
        // remainder of the array will be in the position indicated
        // by the outer index.
        for (int outer = 0; outer < numbers.length; outer++) {

            // Compare the value at numbers[outer] to every other
            // value in the array after it.
            for (int inner = outer + 1; inner < numbers.length; inner++) {

                // If the value at numbers[inner] is smaller than
                // the value at numbers[outer], swap them so that
                // the value at numbers[outer] ends up being the
                // smallest value in the last after the outer index.
                if (numbers[inner] < numbers[outer]) {
                    int tmp = numbers[outer];
                    numbers[outer] = numbers[inner];
                    numbers[inner] = tmp;
                }

            }
        }

    }

}
