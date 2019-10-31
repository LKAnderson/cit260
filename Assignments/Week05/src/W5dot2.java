/**
 * Print all numbers between 100 and 1000
 * that are evenly divisible by both 5 and 6.
 */
public class W5dot2 {

    private static final int MAX_PER_LINE = 10;

    public static void main(String[] argv) {

        // Loop from 100 to 1000, by one
        // also initialize a print counter to 0
        int printCounter = 0;

        for (int i=100; i <= 1000; i++) {

            // if the loop counter % 5 is 0 AND the loop counter % 6 is 0
            // then print out the number
            if ( (i % 5 == 0) && (i % 6 == 0)) {

                System.out.printf("%-4d", i);

                // increment the print counter and check if it's 10. If so, print a
                // newline, the reset it for the next line
                printCounter += 1;

                if (printCounter % MAX_PER_LINE == 0) {
                    System.out.println();
                }
            }
        }
    }
}

