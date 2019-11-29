import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Assignment 11.1
 */
public class W11dot1 {

    public static void main(String[] argv) {

        System.out.println("This program reads a list of integers from the user,\n"
                + "writes them to a file, reads them from the file and calculates\n"
                + "the average of the numbers.\n");
        System.out.println();

        final int NUM_INTEGERS = 10;
        final String FILEPATH = "data.txt";

        System.out.format("Please enter %d integers...\n", NUM_INTEGERS);
        int[] data = readIntegers(NUM_INTEGERS);
        try {
            Storage.storeData(FILEPATH, data);
        } catch (IOException ex) {
            System.err.println("Error storing data: " + ex.getMessage());
            System.exit(1);
        }


        int[] newData = null;

        try {
            newData = Storage.loadData(FILEPATH);
        } catch (IOException ex) {
            System.err.println("Error reading data: " + ex.getMessage());
            System.exit(1);
        }

        if (newData.length != data.length) {
            System.err.println("Error:  Did not read the same number of items that was written.");
            System.exit(1);
        }

        double total = 0;
        for (int d : newData) {
            total += d;
        }

        System.out.format("The average value is: %.2f\n", total / newData.length);
    }


    /**
     * Read integers from the user.
     * @param numToRead
     * @return
     */
    private static int[] readIntegers(int numToRead) {
        var data = new ArrayList<Integer>();

        try (var input = new Scanner(System.in)) {
            while (data.size() < numToRead) {
                System.out.format("Enter integer #%d: ", data.size() + 1);
                try {
                    data.add(input.nextInt());
                } catch (InputMismatchException ex) {
                    if (input.hasNext() == false) {
                        // input stream closed?
                        break;
                    }

                    System.err.println("Please enter a valid integer.");

                    // Skip the invalid value.
                    input.nextLine();

                    continue;
                }
            }
        }

        return Utils.convertListToArray(data);
    }
}
