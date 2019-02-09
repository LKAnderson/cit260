package officehours;

public class LoopTypes {

    public static void main(String[] argv) {
    }
    
    public static void whileLoop() {

        // Basic While Loop

        // set up starting condition
        boolean condition = true;

        // loop under something sets the condition
        // to false
        while (condition == true) {

            // Your repeated code goes in here.

            // Something needs to happen to
            // set your condition to false
            // so your loop can eventually
            // exit
            condition = false;
        }
    }
    
    public static void doWhileLoop() {

        // Do While Loop

        // It's the same, except the body of the
        // loop is executed at least one time
        // before the condition is checked.
        boolean condition = true;

        do {
            // Your repeated code goes in here.

            // Something needs to happen to
            // set your condition to false
            // so your loop can eventually
            // exit
            condition = false;

        } while (condition == true);

    }
    
    public static void forLoop() {
        
        // For loop - this is just a 
        // convenient shorthand of the while
        // loop.
        
        int counter = 0;
        while (counter < 10) {
            
            // Do repeated stuff
            
            counter += 1;
        }
        
        // We can re-write this while loop like this...
        
        for (int counter2 = 0; counter2 < 10; counter2 += 1) {
            
            // Do repeated stuff
        }
    }
}
