package officehours;

import officehours.menu.Menu;
import officehours.menu.MainMenu;
//import officehours.menu.MainMenu_Version1;

public class MenuTest {

    public static void main(String[] args) {
        
        Menu menu = new MainMenu();
        
        menu.display();
        
        System.out.println("Good-bye!");

    }

}
