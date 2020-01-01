import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provide methods to store and load data from files.
 */
public class Storage {

    /**
     * Store the data in the specified file
     * @param filename The name of the file where the data are to be stored.
     * @param data The data to be stored
     * @throws IOException
     */
    public static void storeData(String filename, ArrayList<Parent> data) throws IOException {
        // File format will be:
        // One object per line of the file
        // type parentField child-field
        try (PrintWriter out = new PrintWriter(filename)) {
            for (Parent obj: data) {
                if (obj instanceof IntChild) {
                    IntChild i = (IntChild) obj;
                    out.format("%s|%s|%d\n", "int", obj.getParentField(), i.getChildField());
                } else if (obj instanceof DoubleChild) {
                    DoubleChild d = (DoubleChild) obj;
                    out.format("%s|%s|%f\n", "double", obj.getParentField(), d.getChildField());
                } else {
                    out.format("%s|%s\n", "parent", obj.getParentField());
                }
            }
        } catch(IOException exception) {
            throw new IOException("Couldn't write file", exception);
        }
    }

    /**
     * Load the data from the specified file
     * @param filename The name of the file containing the data.
     * @return The list of objects loaded from the file.
     * @throws IOException
     */
    public static ArrayList<Parent> loadData(String filename) throws IOException {
        ArrayList<Parent> newData = new ArrayList<>();

        // Remember to check if the file exists.

        int lineNumber = 0;

        try (Scanner input = new Scanner(new File(filename))) {
            while(input.hasNextLine()) {
                String line = input.nextLine().trim();
                lineNumber += 1;

                String[] fields = line.split("\\|");
                if (fields[0].equals("parent")) {
                    Parent p = new Parent();
                    if (fields.length > 1) {
                        p.setParentField(fields[1]);
                    }
                    newData.add(p);

                } else if (fields[0].equals("int")) {
                    // int|first child value|1
                    if (fields.length < 3) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    IntChild i = new IntChild();
                    i.setParentField(fields[1]);
                    i.setChildField(Integer.parseInt(fields[2]));
                    newData.add(i);

                } else if (fields[0].equals("double")) {
                    if (fields.length < 3) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    DoubleChild d = new DoubleChild();
                    d.setParentField(fields[1]);
                    d.setChildField(Double.parseDouble(fields[2]));
                    newData.add(d);
                } else {
                    throw new IOException(String.format("Invalid record type '%s' on line %d",fields[0], lineNumber));
                }
            }
        } catch (NumberFormatException exception) {
            throw new IOException("Invalid number format on line " + lineNumber);
        }

        return newData;
    }
}
