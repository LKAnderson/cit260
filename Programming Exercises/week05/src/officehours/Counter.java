package officehours;

public class Counter {
    
    public static void main(String[] argv) {
        
        // Count from 1 to 100 by 4
        System.out.printf("%-3s   %3s\n", "i", "i");
        
        for (int i=1; i <= 100; i += 4) {
            System.out.printf("%-3d = %3d\n", i, i);
        }
        
    }

}
