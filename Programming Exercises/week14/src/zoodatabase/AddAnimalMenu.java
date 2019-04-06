package zoodatabase;

import zoodatabase.menu.Menu;
import zoodatabase.menu.MenuItem;
import zoodatabase.zoo.ZooDatabase;
import zoodatabase.zoo.Animal;
import zoodatabase.zoo.Dog;
import zoodatabase.zoo.Bat;
import zoodatabase.zoo.Canary;
import zoodatabase.zoo.Ostrich;
import zoodatabase.zoo.WingedAnimal;

/**
 * Allows the user to select a type of Animal to be added to the 
 * database.
 */
public class AddAnimalMenu extends Menu {
    
    /**
     * Default constructor. Does nothing.
     */
    public AddAnimalMenu() {
        super();
    }
    
    /**
     * Provide the menu title (or null to skip it)
     * @return
     */
    @Override
    protected String getTitle() {
        return "ADD ANIMAL";
    }
    
    
    /**
     * Provide a menu description, or null to skip it.
     * @return
     */
    @Override
    protected String getDescription() {
        return "Please choose the type of animal you would like to add.";
    }
    
    /**
     * Provide the list of menu items.
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        return new MenuItem[] {
                new MenuItem('1', "Add a Dog"),
                new MenuItem('2', "Add a Bat"),
                new MenuItem('3', "Add a Canary"),
                new MenuItem('4', "Add an Ostrich"),
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
                addDog();
                break;
            case '2':
                addWingedAnimal(new Bat());
                break;
            case '3':
                addWingedAnimal(new Canary());
                break;
            case '4':
                addWingedAnimal(new Ostrich());
                break;
            case 'R':
                return false;
                
            default:
                System.out.println("Invalid Entry");
            
        }
        
        return true;
    }

    /**
     * Prompt for the animal's name. This is common to all animals
     * so we only need the base class referenced here.
     */
    private void getAnimalName(Animal animal) {
        String promptMessage = String.format(
            "Please enter the %s's name: ", 
            animal.getClass().getSimpleName());

        String name = prompt(promptMessage);
        animal.setName(name);
    }

    /**
     * Prompt the user for the new Dog's attributes and
     * add it to the ZooDatabase.
     */
    private void addDog() {

        Dog newDog = new Dog();

        getAnimalName(newDog);

        String promptMessage = String.format(
            "Please enter the %s's favorite toy: ",
            Dog.class.getSimpleName());

        String toy = prompt(promptMessage);

        newDog.setFavoriteToy(toy);

        ZooDatabase.getZoo().add(newDog);
        ZooDatabase.storeZoo();
    }

    /**
     * Prompt the user for the new WingedAnimal's name and
     * add it to the ZooDatabase.
     */
    private void addWingedAnimal(WingedAnimal animal) {
        getAnimalName(animal);
        ZooDatabase.getZoo().add(animal);
        ZooDatabase.storeZoo();
    }
    
}
