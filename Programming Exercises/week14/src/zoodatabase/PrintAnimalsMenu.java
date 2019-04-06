package zoodatabase;

import zoodatabase.menu.Menu;
import zoodatabase.menu.MenuItem;
import zoodatabase.zoo.Animal;
import zoodatabase.zoo.Bat;
import zoodatabase.zoo.Canary;
import zoodatabase.zoo.Dog;
import zoodatabase.zoo.Ostrich;
import zoodatabase.zoo.WingedAnimal;
import zoodatabase.zoo.ZooDatabase;

public class PrintAnimalsMenu extends Menu {
    
    /**
     * Default constructor. Does nothing.
     */
    public PrintAnimalsMenu() {
        super();
    }
    
    /**
     * Provide the menu title (or null to skip it)
     * @return
     */
    @Override
    protected String getTitle() {
        return "PRINT ANIMALS";
    }
    
    
    /**
     * Provide a menu description, or null to skip it.
     * @return
     */
    @Override
    protected String getDescription() {
        return "Choose how to enjoy the zoo!";
    }
    
    /**
     * Provide the list of menu items.
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        return new MenuItem[] {
                new MenuItem('1', "See all of the animals"),
                new MenuItem('2', "See the Dogs"),
                new MenuItem('3', "See the Winged Animals"),
                new MenuItem('4', "See the Bats"),
                new MenuItem('5', "See the Canaries"),
                new MenuItem('6', "See the Ostriches"),
                new MenuItem('R', "Return")
        };
    }
    
    
    /**
     * Handle the user's menu selection.
     * @param key
     * @return false if the menu should exit and return to whatever called it.
     */
    @Override
    protected boolean handleMenuSelection(char key) {
        
        switch (Character.toUpperCase(key)) {
            case '1': 
                printAnimals(Animal.class);
                break;
            case '2':
                printAnimals(Dog.class);
                break;
            case '3':
                printAnimals(WingedAnimal.class);
                break;
            case '4':
                printAnimals(Bat.class);
                break;
            case '5':
                printAnimals(Canary.class);
                break;
            case '6':
                printAnimals(Ostrich.class);
                break;
            case 'R':
                return false;
                
            default:
                System.out.println("Invalid Entry");
            
        }
        
        return true;
    }

    
    /**
     * Print out all animals in the database that match
     * the specified animalClass.
     * @param animalClass
     */
    private void printAnimals(Class animalClass) {

        boolean somethingPrinted = false;

        for (Animal animal : ZooDatabase.getZoo()) {
            if (animalClass.isInstance(animal)) {
                System.out.println(animal.getDescription());
                somethingPrinted = true;
            }
        }

        if (somethingPrinted == false) {
            System.out.printf("We don't currently have any %ss.%n", animalClass.getSimpleName());
        }
    }
}
