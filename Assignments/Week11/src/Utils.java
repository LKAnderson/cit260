import java.util.ArrayList;

/**
 * Some utility methods to help manage data.
 */
public class Utils {

    /**
     * Convert ArrayList of Integer to int[].
     * @param data
     * @return
     * @throws IllegalArgumentException if data is null
     */
    public static int[] convertListToArray(ArrayList<Integer> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data must not be null");
        }

        int[] array = new int[data.size()];
        for (int i=0; i < data.size(); i++) {
            array[i] = data.get(i);
        }

        return array;
    }
}
