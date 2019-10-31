/**
 * Produce the following table using a loop.
 *
 *  kilograms     pounds
 *  ---------     ------
 *  1             2.2
 *  3             6.6
 *  5             11.0
 *  7             15.4
 *  9             19.8
 *  11            24.2
 *  13            28.6
 *  15            33.0
 */
public class W5dot1 {

    private final static double KG_PER_POUND = 2.2;

    public static void main(String[] argv) {

        // print the table headers (alignment matters)
        System.out.printf("%9s     %6s\n", "kilograms", "pounds");
        System.out.printf("%9s     %6s\n", "---------", "------");

        // loop with a counter of only the odd
        // numbers between 1 and 199.
        for(int kilograms = 1; kilograms <= 15; kilograms += 2) {

            // Convert the kilograms to pounds (1 kg = 2.2 lbs)
            double pounds = kilograms * KG_PER_POUND;

            // Print the formatted table
            System.out.printf("%-9d     %-6.1f\n", kilograms, pounds);
        }
    }
}
