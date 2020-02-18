/**
 * Ask the user for 5 double values and print out the mean and standard deviation.
 */
public class W7dot2 {

    public static void main(String[] argv) {
        double[] values = Inputs.getDoubles(5, "Please enter 5 numbers (one per line):");
        System.out.format("The mean is %.02f%n", Stats.average(values));
        System.out.format("The standard deviation is %.02f%n", Stats.deviation(values));

        values = Inputs.getDoubles(argv);
        System.out.format("The mean is %.02f%n", Stats.average(values));
        System.out.format("The standard deviation is %.02f%n", Stats.deviation(values));
    }
}