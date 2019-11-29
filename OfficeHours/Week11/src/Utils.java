import java.util.ArrayList;

/**
 * Utility methods for dealing with string arrays and arraylists.
 */
public class Utils {

    /**
     * Converts arraylist of string to array
     * @param data
     * @return
     */
    public static String[] convertListToArray(ArrayList<String> data) {
        // convert arraylist to array
        String[] strings = new String[data.size()];
        for (int i=0; i < data.size(); i++) {
            strings[i] = data.get(i);
        }

        return strings;
    }
}
