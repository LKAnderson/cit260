package officehours.menu;

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
        return "This is the main menu of the program.";
    }
    
    /**
     * Provide the list of menu items.
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        return new MenuItem[] {
                new MenuItem('1', "Choose Option 1"),
                new MenuItem('2', "Choose Option 2"),
                new MenuItem('3', "Choose Option 3"),
                new MenuItem('H', "Help Menu"),
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
                System.out.println("You typed 1");
                break;
            case '2':
                System.out.println("You typed 2");
                break;
            case '3':
                System.out.println("You typed 3");
                break;
                
            case 'H':
                Menu helpMenu = new HelpMenu();
                helpMenu.display();
                break;
                
            case 'Q':
                return false;
                
            default:
                System.out.println("Invalid Entry");
            
        }
        
        return true;
    }

}
