import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import values.BooleanValue;
import values.DoubleValue;
import values.IntValue;
import values.StringValue;
import values.Value;

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
    public static void storeData(String filename, ArrayList<Value> data) throws IOException {
        // Text format, one line per object, delimited by |
        try (var writer = new PrintWriter(filename)){
            writer.println("// file format: data-type | name | value");
            for (var value: data) {
                if (value instanceof StringValue) {
                    var stringValue = (StringValue)value;
                    writer.format("string|%s|%s\n", stringValue.getName(), stringValue.getValue());
                } else if (value instanceof BooleanValue) {
                    var boolValue = (BooleanValue)value;
                    writer.format("boolean|%s|%b\n", boolValue.getName(), boolValue.getValue());
                } else if (value instanceof IntValue) {
                    var intValue = (IntValue)value;
                    writer.format("int|%s|%d\n", intValue.getName(), intValue.getValue());
                } else if (value instanceof DoubleValue) {
                    var doubleValue = (DoubleValue)value;
                    writer.format("double|%s|%f\n", doubleValue.getName(), doubleValue.getValue());
                }
            }
        }
    }

    /**
     * Load the data from the specified file
     * @param filename The name of the file containing the data.
     * @return The list of objects loaded from the file.
     * @throws IOException
     */
    public static ArrayList<Value> loadData(String filename) throws IOException {
        var data = new ArrayList<Value>();

        try (var input = new Scanner(new File(filename))) {
            int lineNumber = 0;

            while (input.hasNextLine()) {
                var line = input.nextLine();
                lineNumber += 1;

                if (line.trim().startsWith("//")) {
                    continue;
                }

                var fields = line.trim().split("\\|");
                if (fields.length != 3) {
                    throw new IOException("Invalid file format on line " + lineNumber);
                }

                try {
                    switch(fields[0]) {
                        case "string":
                            var stringValue = new StringValue();
                            stringValue.setName(fields[1]);
                            stringValue.setValue(fields[2]);
                            data.add(stringValue);
                            break;
                        
                        case "boolean":
                            var boolValue = new BooleanValue();
                            boolValue.setName(fields[1]);
                            boolValue.setValue(Boolean.parseBoolean(fields[2]));
                            data.add(boolValue);
                            break;

                        case "int":
                            var intValue = new IntValue();
                            intValue.setName(fields[1]);
                            intValue.setValue(Integer.parseInt(fields[2]));
                            data.add(intValue);
                            break;

                        case "double":
                            var doubleValue = new DoubleValue();
                            doubleValue.setName(fields[1]);
                            doubleValue.setValue(Double.parseDouble(fields[2]));
                            data.add(doubleValue);
                            break;
                    }
                } catch(NumberFormatException exception) {
                    throw new IOException("Invalid file format on line " + lineNumber, exception);
                }
            }    
        }

        return data;
    }
}
