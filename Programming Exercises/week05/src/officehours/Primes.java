package officehours;

public class Primes {
    
    // List 5 numbers per line.
    static final int PRINT_MAX = 5;

    public static void main(String[] argv) {
        
        // Find all primes between 1 and 1000
         
        int printCounter = 0;
        
        // Loop from 1 to 1000
        for (int number = 2; number <= 1000; number++) {
            
            // Check for prime:             
            // Assume prime
            boolean isPrime = true;
            
            // divide number by all numbers leading up to it
            for (int factor = 2; factor < number; factor++) {
                // if number is evenly divisible by the other number
                // then not prime.
                if (number % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            // If it's a prime number, print it out.
            if (isPrime == true) {
                
                System.out.printf("%d", number);
                
                printCounter += 1;
                
                // Check to see if we've hit the max per line.
                // If so, print a new line.
                
                if (printCounter % PRINT_MAX == 0) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
            
        }
        
        // Test cases:
        // 2, 3, 7, 11, 17, 31, 101
        
    }
}
