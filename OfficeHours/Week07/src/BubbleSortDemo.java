import java.util.Arrays;
import java.util.Scanner;

/**
 * Demonstrate using arrays while doing Bubble Sort operations.
 */

public class BubbleSortDemo {
    public static void main(String[] argv) {

        // Demonstrate a hard-coded array.
        // String[] inputs = new String[] { "one", "two", "three" };
        // double[] inputs = new double[] { 1.0, 2.0, 3.0 };
        // var inputs = new double[] { 1.0, 2.0, 3.0 };

        final int MAX_INPUTS = 7;
        String[] inputs = new String[MAX_INPUTS];

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter 7 strings (one per line):");

            // We could use a for loop instead of a while loop.
            // Here's what it would look like...
            // for (int stringCount=0; stringCount < MAX_INPUTS;) {

            int stringCount = 0;
            while (stringCount < MAX_INPUTS) {
                System.out.format("%d/%d: ", stringCount + 1, MAX_INPUTS);
                String input = scanner.nextLine().trim();

                if (input.length() == 0) {
                    System.err.println("Please enter a value.");
                    continue;
                }

                inputs[stringCount] = input;
                stringCount += 1;
            }
        }

        String[] copiedData = sortArrayCopy(inputs);
        printArray(inputs);
        printArray(copiedData);

        sortArray(inputs);
        printArray(inputs);

    }

    /**
     * Sort the array in place
     * @param data the data to be sorted
     */
    public static void sortArray(String[] data) {
        // Now sort the values.
        for (int i = 0; i < data.length; i++) {
            for (int j=i+1; j < data.length; j++) {
                // Sorting by length of the word instead of alphabetically
                // if (data[j].length() > data[i].length()) {
                if (data[j].compareToIgnoreCase(data[i]) < 0) {
                    String tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }

    /**
     * Sort a copy of the array
     * @param sourceData the data to be sorted
     */
    public static String[] sortArrayCopy(String[] sourceData) {

        String[] dataCopy = Arrays.copyOf(sourceData, sourceData.length);
        sortArray(dataCopy);
        return dataCopy;
    }

    /**
     * Print an array to the screen.
     * @param data
     */
    public static void printArray(String[] data) {
        // print the whole loop
        for (String value : data) {
            System.out.println(value);
        }
    }
}
