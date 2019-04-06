package zoodatabase;

import zoodatabase.menu.Menu;

public class Main {

    public static void main(String[] argv) {

        // create the MainMenu object
        Menu mainMenu = new MainMenu();

        // display it (when it returns, the program will end.)
        mainMenu.display();

        // Say thank you, and exit
        System.out.println();
        System.out.println("Thank you!");
    }
    
    
}