import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Assignment 11.1
 */
public class W11dot1 {

    public static void main(String[] argv) {

        final int NUM_INTEGERS = 10;
        final String FILEPATH = "data.txt";

        System.out.format("Please enter %d integers...\n", NUM_INTEGERS);
        Integer[] data = readIntegers(NUM_INTEGERS);
        try {
            storeData(FILEPATH, data);
        } catch (IOException ex) {
            System.err.println("Error storing data: " + ex.getMessage());
            System.exit(1);
        }

        try {
            double average = getAverageFromFileAlt(FILEPATH);
            System.out.format("The average value is: %.2f\n", average);
        } catch (IOException ex) {
            System.err.println("Error reading data: " + ex.getMessage());
            System.exit(1);
        }
    }

    /**
     * Read integers from the user.
     * @param numToRead
     * @return
     */
    private static Integer[] readIntegers(int numToRead) {
        var data = new ArrayList<Integer>();

        try (var input = new Scanner(System.in)) {
            while (data.size() < numToRead) {
                System.out.format("Enter integer #%d: ", data.size() + 1);
                try {
                    data.add(input.nextInt());
                } catch (InputMismatchException ex) {
                    if (input.hasNext() == false) {
                        // input stream must be closed
                        break;
                    }
                    
                    System.err.println("Please enter a valid integer.");

                    // Skip the invalid value.
                    input.nextLine();
                }
            }
        }

        return data.toArray(new Integer[data.size()]);
    }

    /**
     * Stores the array of data in the file specified by the filepath.
     * @param filepath The path to the file
     * @param data The data to be stored.
     * @throws IOException
     */
    public static void storeData(String filepath, Integer[] data) throws IOException {
        try (var output = new PrintWriter(filepath)) {
            
            Arrays.stream(data).forEach(i -> output.println(i));

            // the line of code above is equivalent to the 
            // following for-each loop. Can you match the 
            // parts?
            //
            // for (int i: data) {
            //     output.println(i);
            // }
        }
    }

    /**
     * Loads the array of data from the file specified by filepath
     * @param filepath The path to the file.
     * @return
     * @throws IOException
     */
    public static double getAverageFromFile(String filepath) throws IOException  {
        // Check if file exists.
        var file = new File(filepath);
        if (file.exists() == false) {
            throw new IOException("File not found: " + filepath);
        }

        if (file.canRead() == false) {
            throw new IOException("File cannot be read: " + filepath);
        }

        double total = 0;
        int count = 0;

        try (var input = new Scanner(new File(filepath))) {

            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                total += Integer.parseInt(line);
                count += 1;
            }
        } catch (NumberFormatException ex) {
            throw new IOException("Invalid number value in file", ex);
        }

        return total/count;
    }

    /**
     * (Alternative) Loads the array of data from the file specified by filepath.
     * This version of the method uses the Java Streams API to apply a 
     * functional style programming solution to the problem. It also 
     * uses the java.nio package for file operations.
     * 
     * @param filepath The path to the file.
     * @return
     * @throws IOException
     */
    public static double getAverageFromFileAlt(String filepath) throws IOException  {
        // Get a Path object, which knows how to check all sorts
        // of things about files.
        var path = Paths.get(filepath);
        
        // Check if file exists.
        if (Files.exists(path) == false) {
            throw new IOException("File not found: " + filepath);
        }

        // Check if our program is able to read the file.
        if (Files.isReadable(path) == false) {
            throw new IOException("File cannot be read: " + filepath);
        }

        // Get a stream (a special kind of list processor) to
        // process the lines of the file, one by one.
        try (var stream = Files.lines(Paths.get(filepath))) {

            // process each line, convert it to an integer using
            // the Integer.parseInt() method, collect all of the
            // integers into an average, and if there is an error,
            // throw a new exception.
            return stream
                .mapToInt(Integer::parseInt)
                .average()
                .orElseThrow(() -> new IOException("Could not get average."));

        } catch (NumberFormatException ex) {
            throw new IOException("Invalid number value in file", ex);
        }
    }
}
