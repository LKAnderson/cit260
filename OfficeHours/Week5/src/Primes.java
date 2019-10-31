/**
 * Print a table of prime numbers between 1 and 1000
 */
public class Primes {

    public static void main(String[] args) {

        System.out.format("%-4s      %-4s%n", "cnt", "nbr");
        System.out.format("----      ----%n");

        // for each number (number) between 1 and 1000:
        for (int number = 1, count=0; number <= 1000; number++) {

            boolean isPrime = true;

            // for each number (factor) between 2 and number-1
            for (int factor = 2; factor < number - 1; factor++) {

                if (number % factor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime == true){
                count += 1;
                System.out.format("%-4d      %-4d%n", count, number);
            }
        }
    }
}
