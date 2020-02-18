import java.util.Scanner;

/**
 * Provide methods for getting input from users.
 */
public class Inputs {

    /**
     * Read double values from the user.
     * @param count The number of values to read
     * @param prompt The message to print
     * @return
     */
    public static double[] getDoubles(final int count, final String prompt) {

        double[] inputs = new double[count];

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(prompt);

            int stringCount = 0;
            while (stringCount < count) {
                System.out.format("%d/%d: ", stringCount + 1, count);
                inputs[stringCount] = scanner.nextDouble();
                stringCount += 1;
            }
        }

        return inputs;
    }

    /**
     * Convert an array of strings to an array of doubles.
     * @param input the array of strings
     * @return the array of doubles.
     */
    public static double[] getDoubles(String[] input) {
        double[] output = new double[input.length];
        for (int i=0; i < input.length; i++) {
            try {
                output[i] = Double.parseDouble(input[i]);
            } catch (NumberFormatException exception) {
                // We'll set it to 0. We'll learn how to 
                // handle this error better in Week 11.
                output[i] = 0;
            }
        }
        return output;
    }
}
