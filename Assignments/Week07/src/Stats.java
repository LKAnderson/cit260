/**
 * Utility class to provide Statistical calculations.
 */
public class Stats {

    /**
     * Calculate the mean of an array of double values.
     * @param values
     * @return
     */
    public static double mean(final double[] values) {
        double total = 0;
        for (double value: values) {
            total += value;
        }
        return total/values.length;
    }

    /**
     * Find the average of an array of double values (This
     * method is the same as mean().
     * @param values
     * @return
     */
    public static double average(final double[] values){
        return mean(values);
    }

    /**
     * Calculate the standard deviation of an array of double values.
     * @param values
     * @return
     */
    public static double deviation(final double[] values) {
        double mean = mean(values);

        double sumDeviation = 0;
        for (double num: values) {
            sumDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(sumDeviation / (values.length-1));
    }
}
