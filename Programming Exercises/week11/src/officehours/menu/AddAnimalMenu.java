package officehours.menu;

import officehours.database.Bat;
import officehours.database.Canary;
import officehours.database.Dog;
import officehours.database.Ostrich;
import officehours.database.WingedAnimal;
import officehours.database.ZooDatabase;

/**
 * This class provides the menu and logic for adding animals to the zoo database.
 */
public class AddAnimalMenu extends ZooMenu {

    // declare this list of menu items as a constant, since they won't
    // ever change during the program.
    private static final MenuItem[] MENU_ITEMS = { 
        new MenuItem('D', "Dog"), 
        new MenuItem('C', "Canary"),
        new MenuItem('O', "Ostrich"), 
        new MenuItem('B', "Bat"), 
        new MenuItem('R', "Return") 
    };

    // Constants for our switch logic.
    private static final String BAT = "bat";
    private static final String CANARY = "canary";
    private static final String OSTRICH = "ostrich";

    /**
     * Default constructor. Does nothing.
     */
    public AddAnimalMenu() {
        super();
    }

    /**
     * Provide the menu title (or null to skip it)
     * 
     * @return
     */
    @Override
    protected String getTitle() {
        return "ZOO DATABASE - ADD ANIMAL MENU";
    }

    /**
     * Provide a menu description, or null to skip it.
     * 
     * @return
     */
    @Override
    protected String getDescription() {
        return "Choose a type of animal to add:";
    }

    /**
     * Provide the list of menu items.
     * 
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        return MENU_ITEMS;
    }

    /**
     * Handle the user's menu selection.
     * 
     * @param key
     * @return false if the menu should exit and return to whatever called it.
     */
    @Override
    protected boolean handleMenuSelection(char key) {

        switch (Character.toUpperCase(key)) {
        case 'D':
            addDog();
            break;
        case 'C':
            addWingedAnimal(CANARY);
            break;
        case 'O':
            addWingedAnimal(OSTRICH);
            break;
        case 'B':
            addWingedAnimal(BAT);
            break;

        case 'R':
            return false;

        default:
            System.out.println("Invalid Entry");

        }

        return true;
    }

    /**
     * Prompt for the WingedAnimal's name and add it to the database.
     * 
     * @param type The string constant of the winged animal to be added.
     */
    private void addWingedAnimal(String type) {

        // Make sure we get called with one of our valid winged animal constants
        if (! (type.equals(CANARY) || type.equals(BAT) || type.equals(OSTRICH)) ) {
            throw new IllegalArgumentException("Programmer error: " + type);
        }

        // Prompt for the name.
        var name = prompt(String.format("Enter the %s's name: ", type), true);

        WingedAnimal animal = null;
        
        if (type.equals(CANARY)) {
            animal = new Canary(name);
        } else if (type.equals(BAT)) {
            animal = new Bat(name);
        } else if (type.equals(OSTRICH)) {
            animal = new Ostrich(name);
        }

        ZooDatabase.getZoo().add(animal);
        System.out.format("%s has been added to the database.%n", name);
        
        saveZoo();
    }
    
    /**
     * Prompt for the dog's information and add it to the database.
     */
    private void addDog() {
        var name = prompt("Enter the dog's name: ", true);
        var favoriteToy = prompt(String.format("Enter %s's favorite toy: ", name), true);
        
        var dog = new Dog(name, favoriteToy);
        ZooDatabase.getZoo().add(dog);
        System.out.format("%s has been added to the database.%n", name);
        
        saveZoo();
    }
}
