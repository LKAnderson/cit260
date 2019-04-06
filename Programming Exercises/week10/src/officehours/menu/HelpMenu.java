package officehours.menu;

public class HelpMenu extends Menu {
    
    /**
     * Default constructor. Does nothing.
     */
    public HelpMenu() {
        super();
    }
    
    /**
     * Provide the menu title (or null to skip it)
     * @return
     */
    @Override
    protected String getTitle() {
        return "HELP MENU";
    }
    
    
    /**
     * Provide a menu description, or null to skip it.
     * @return
     */
    @Override
    protected String getDescription() {
        return "Get Help Here";
    }
    
    /**
     * Provide the list of menu items.
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        return new MenuItem[] {
                new MenuItem('1', "Help Topic 1"),
                new MenuItem('2', "Help Topic 2"),
                new MenuItem('3', "Help Topic 3"),
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
                System.out.println("Help Text 1");
                break;
            case '2':
                System.out.println("Help Text 2");
                break;
            case '3':
                System.out.println("Help Text 3");
                break;
                
            case 'R':
                return false;
                
            default:
                System.out.println("Invalid Entry");
            
        }
        
        return true;
    }

}
