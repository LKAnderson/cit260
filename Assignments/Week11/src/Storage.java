import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class provides methods to store and load
 * data in files.
 */
public class Storage {

    /**
     * Stores the array of data in the file specified by the filepath.
     * @param filepath The path to the file
     * @param data The data to be stored.
     * @throws IOException
     */
    public static void storeData(String filepath, int[] data) throws IOException {
        try (var output = new PrintWriter(filepath)) {
            for (int d : data) {
                output.println(d);
            }
        }
    }

    /**
     * Loads the array of data from the file specified by filepath
     * @param filepath The path to the file.
     * @return
     * @throws IOException
     */
    public static int[] loadData(String filepath) throws IOException  {
        // Check if file exists.
        var file = new File(filepath);
        if (file.exists() == false) {
            throw new IOException("File not found: " + filepath);
        }

        if (file.canRead() == false) {
            throw new IOException("File cannot be read: " + filepath);
        }

        var data = new ArrayList<Integer>();

        try (var input = new Scanner(new File(filepath))) {
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                data.add(Integer.parseInt(line));
            }
        } catch (NumberFormatException ex) {
            throw new IOException("Invalid number value in file: " + ex.getMessage());
        }

        return Utils.convertListToArray(data);
    }
}
