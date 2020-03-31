import java.util.Date;

/**
 * Print out various date timestamps.
 */
public class W8dot2 {

    public static void main(String[] args) {

        // Create a Date object.
        Date date = new Date();

        // Create an array of time values to set
        // in the Date and see what the result is.
        long[] times = new long[] { 
            10_000L, 
            100_000L, 
            10_000_000L, 
            100_000_000L, 
            1_000_000_000L, 
            10_000_000_000L,
            100_000_000_000L 
        };

        // Walk the array of times, set the Date
        // and print out the results.
        //for (long time : times) {
        for (int i=0; i < times.length; i++) {
            long time = times[i];
        
            date.setTime(time);
            System.out.println(date.toString());
        }


    }
}
