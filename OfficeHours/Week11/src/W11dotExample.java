import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that reads an unlimited number of strings from the user, writes them
 * to a file named "strings.txt", then reads them back in and prints an alphabetically
 * ordered list of each word in the file.
 */
public class W11dotExample {

    public static void main(String[] args) {
        String[] strings = readStrings();

        try {
            Storage.storeStrings("strings.txt", strings);
        } catch (IOException ex) {
            System.err.println("Error writing file: " + ex.getMessage());
        }

        String[] newStrings = null;

        try {
            newStrings = Storage.loadStrings("strings.txt");
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }

        // Demonstrates how to convert string data read from a file to integers.
        for (String s: newStrings) {
            try {
                int i = Integer.parseInt(s);
                System.out.println("Found int: " + i);
            } catch (NumberFormatException ex) {
                // do nothing
            }
        }

        Arrays.sort(newStrings);

        for (String s: newStrings) {
            System.out.println(s);
        }
    }

    /**
     * Read in strings until there is a blank line, or the input stream closes.
     * @return
     */
    private static String[] readStrings() {
        ArrayList<String> rawData = new ArrayList<>();

        System.out.println("Please enter some data...");

        try (var scanner = new Scanner(System.in)) {
            String str = null;
            while(scanner.hasNextLine() == true) {
                str = scanner.nextLine().trim();
                if (str.length() == 0) {
                    break;
                }

                for (String part : str.split("\\s+")) {
                    rawData.add(part);
                }
            }
        }

        return Utils.convertListToArray(rawData);
    }
}
