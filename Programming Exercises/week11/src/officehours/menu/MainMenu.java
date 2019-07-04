package officehours.menu;

import officehours.database.ZooDatabase;

public class MainMenu extends ZooMenu {
    
    /**
     * Default constructor. Does nothing.
     */
    public MainMenu() {
        super();
    }
    
    /**
     * Provide the menu title (or null to skip it)
     * @return
     */
    @Override
    protected String getTitle() {
        return "ZOO DATABASE - MAIN MENU";
    }
    
    
    /**
     * Provide a menu description, or null to skip it.
     * @return
     */
    @Override
    protected String getDescription() {
        return null;
    }
    
    /**
     * Provide the list of menu items.
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        return new MenuItem[] {
                new MenuItem('P', "Print the database"),
                new MenuItem('A', "Add a new animal to the database"),
                new MenuItem('R', "Remove an animal from the database"),
                new MenuItem('Q', "Quit Program")
        };
    }
    
    
    /**
     * Handle the user's menu selection.
     * @param key
     * @return false if the menu should exit and return to whatever called it.
     */
    @Override
    protected boolean handleMenuSelection(char key) {
        
        // Do what the user selected
        switch (Character.toUpperCase(key)) {
            case '1':
                printDatabase();
                break;
            case '2': 
                addAnimal();
                break;
            case '3':
                removeAnimal();
                break;
            case 'Q':
                return false;
                
            default:
                System.out.println("Invalid Entry. Please choose an option from the menu.");
        }
        
        return true;
    }

    /**
     * Print the database report to the screen.
     */
    private void printDatabase() {
        System.out.println();
        System.out.println(ZooDatabase.getZooReport());
        System.out.println();
    }

    /**
     * Remove an animal from the database. This will print the list
     * of animals and then prompt the user for the number of the entry
     * to be removed.
     */
    private void removeAnimal() {
        printDatabase();
        var zoo = ZooDatabase.getZoo();

        if (zoo.size() == 0){
            System.out.println("There are no animals in the zoo.");
            return;
        }

        var indexString = prompt("Enter the number of the animal to remove: ");
        var index = -1;
        try {
            index = Integer.parseInt(indexString);
        } catch (NumberFormatException exception) {
            System.err.println("Please enter a valid index.");
            return;
        }
        
        if (index < 1 || index > zoo.size()) {
            System.err.println("Please enter a valid index.");
            return;
        }

        var animal = zoo.remove(index - 1);

        System.out.println(animal.getName() + " has been removed from the database.");
        saveZoo();
    }

    /**
     * Add a new animal to the database
     */
    private void addAnimal() {
        new AddAnimalMenu().display();
        // when this menu returns, it will be done so we can just
        // return to the top of our own main menu.
    }

}
