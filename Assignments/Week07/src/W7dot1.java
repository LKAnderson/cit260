/**
 * Ask the user for 5 double values and print out the average.
 */
public class W7dot1 {

    public static void main(String[] argv) {
        double[] values = Inputs.getDoubles(5, "Please enter 5 numbers (one per line):");
        System.out.format("The average is %.02f\n", Stats.average(values));

        values = Inputs.getDoubles(argv);
        System.out.format("The average is %.02f\n", Stats.average(values));
    }
}
