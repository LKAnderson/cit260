package zoodatabase;

import zoodatabase.menu.Menu;
import zoodatabase.menu.MenuItem;

public class MainMenu extends Menu {
    
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
        return "MAIN MENU";
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
                new MenuItem('1', "Add an Animal"),
                new MenuItem('2', "Remove an Animal"),
                new MenuItem('3', "See all the Animals"),
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
        
        switch (Character.toUpperCase(key)) {
            case '1': 
                addAnimalMenu();
                break;
            case '2':
                removeAnimalMenu();
                break;
            case '3':
                printAnimalsMenu();
                break;
            case 'Q':
                return false;
                
            default:
                System.out.println("Invalid Entry");
            
        }
        
        return true;
    }

    /**
     * Launch the AddAnimalsMenu
     */
    private void addAnimalMenu() {
        Menu menu = new AddAnimalMenu();
        menu.display();
    }

    /**
     * Launch the RemoveAnimalsMenu
     */
    private void removeAnimalMenu() {
        Menu menu = new RemoveAnimalMenu();
        menu.display();
    }

    /**
     * Launch the PrintAnimalsMenu
     */
    private void printAnimalsMenu() {
        Menu menu = new PrintAnimalsMenu();
        menu.display();
    }

}
