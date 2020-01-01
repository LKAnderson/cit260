import java.io.IOException;
import java.util.ArrayList;

/**
 * Demonstrate writing files and reading them back in.
 */
public class Demo {
    
    public static void main(String[] args) {

        // Set up our data.
        ArrayList<Parent> objects = new ArrayList<>();
        objects.add(new Parent("first value"));
        objects.add(new IntChild( 1, "first child value"));
        objects.add(new DoubleChild( 2.0, "second child value"));

        // Print it out.
        System.out.println("Here's the list...\n");
        printObjects(objects);

        // Save the data to a file.
        try {
            Storage.storeData("data.txt", objects);
        } catch (IOException exception) {
            System.err.println("Got an exception writing the data!");
            exception.printStackTrace(System.err);
            return;
        }

        // Reload the data and print it out again.
        try {
            ArrayList<Parent> reloadedObjects = Storage.loadData("data.txt");
            System.out.println("\n\nHere's the new list...\n");
            printObjects(reloadedObjects);
        } catch (IOException exception) {
            System.err.println("Got an exception reading the data!");
            exception.printStackTrace(System.err);
            return;
        } catch (Exception exception) {
            System.err.println("Got an unexpected exception!");
            exception.printStackTrace(System.err);
            return;
        }
    }

    /**
     * Print the list of objects to the screen.
     * @param objects
     */
    private static void printObjects(ArrayList<Parent> objects) {
        if (objects == null) {
            throw new IllegalArgumentException("objects must not be null");
        }

        for (Parent obj: objects) {
            System.out.format("%s - %s\n", obj.polymorphicMethod(), obj.toString());
        }
    }
}
