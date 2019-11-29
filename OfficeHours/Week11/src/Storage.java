import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility functions for reading/writing strings to files.
 */
public class Storage {

    /**
     * Writes the array of strings to the file specified by filename
     * @param filename
     * @param data
     */
    public static void storeStrings(String filename, String[] data) throws IOException {

        if (filename == null || data == null) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        try (PrintWriter out = new PrintWriter(filename)) {
            for (String str : data) {
                out.println(str);
            }
        }
    }

    /**
     * Read strings from the file specified by filename.
     * @param filename
     * @return
     * @throws IOException
     */
    public static String[] loadStrings(String filename) throws IOException {
        if (filename == null || filename.trim().length() == 0) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        File file = new File(filename);
        if (file.exists() == false || file.canRead() == false) {
            throw new IOException("Cannot find or read file");
        }

        ArrayList<String> rawData = new ArrayList<>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                rawData.add(input.nextLine().trim());
            }
        }

        return Utils.convertListToArray(rawData);
    }
}
