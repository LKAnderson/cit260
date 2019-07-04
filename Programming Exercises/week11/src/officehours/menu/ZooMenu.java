package officehours.menu;

import java.io.IOException;

import officehours.database.ZooDatabase;

/**
 * This menu class simply addds a saveZoo() method to the menu system.
 */
public abstract class ZooMenu extends Menu {

    /**
     * Save the new zoo entries to our file.
     */
    protected void saveZoo() {
        try {
            ZooDatabase.storeZoo();
        } catch(IOException exception) {
            System.err.println("WARNING: The zoo database file could not be saved.");
        }
    }
}