package officehours;

public class Primes {

    public static void main(String[] argv) {
        
        // Find all primes between 1 and 1000
        // List 5 numbers per line.
        final int PRINT_MAX = 10;
        
        int printCounter = 0;
        
        // Loop from 1 to 1000
        for (int number = 2; number <= 1000; number++) {
            
            // Check for prime:             
            // Assume prime
            boolean isPrime = true;
            
            // divide number by all numbers leading up to it
            for (int i = 2; i < number; i++) {
                // if number is evenly divisible by the other number
                // then not prime.
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime == true) {
                System.out.printf("%3d ", number);
                printCounter += 1;
                if (printCounter % PRINT_MAX == 0) {
                    System.out.println();
                }
            }
            
        }
        
        
        
        // Test cases:
        // 3, 7, 11, 17, 31, 101
        
        
    }
}
