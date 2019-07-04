package officehours;

import officehours.menu.MainMenu;
import officehours.menu.Menu;

/**
 * The main class for our Zoo application.
 */
public class Zoo {

    public static void main(String[] argv) {

        System.out.println();
        System.out.println("Welcome to the Zoo!");
        System.out.println();

        // A little pause for dramatic effect
        Menu.delay(1000);

        // All we do here is create our main menu and start its
        // display() method. When it returns, our program is done.
        new MainMenu().display();

        System.out.println("Thank you! Come again soon.");
    }
    
}