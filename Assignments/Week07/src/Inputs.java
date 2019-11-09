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
}
