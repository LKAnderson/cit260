import java.io.IOException;
import java.util.ArrayList;

import values.BooleanValue;
import values.DoubleValue;
import values.IntValue;
import values.StringValue;
import values.Value;

/**
 * Demonstrate writing files and reading them back in.
 */
public class Demo {
    
    public static void main(String[] args) {

        // Set up our data.
        var values = new ArrayList<Value>();
        values.add(new StringValue("value #1", "This is my string value"));
        values.add(new BooleanValue("value #2", true));
        values.add(new IntValue("value #3", 2020));
        values.add(new DoubleValue("value #4", 95.5));

        printValues("Original Values", values);

        // Save the data to a file.
        try {
            Storage.storeData("values.txt", values);
        } catch (IOException exception) {
            System.err.println("Got an exception writing the data!");
            System.err.println(exception);
            return;
        }

        // Reload the data and print it out again.
        try {
            ArrayList<Value> reloadedValues = Storage.loadData("values.txt");
            printValues("Reloaded Values", reloadedValues);
        } catch (IOException exception) {
            System.err.println("Got an exception reading the data!");
            System.err.println(exception);
        } 
    }


    /**
     * Print the list of values under the given title
     */
    private static void printValues(String title, ArrayList<Value> values) {
        System.out.println(title);
        
        if (values == null || values.isEmpty()) {
            System.out.println("Nothing to print");
            return;
        }

        for (var value: values) {
            System.out.println(value.toString());
        }

        System.out.println();
    }

}
