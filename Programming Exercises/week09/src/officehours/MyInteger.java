package officehours;

/**
 * The MyInteger class to meet the requirements of A10.3
 */
class MyInteger {

    private int value;

    /**
     * Constructor
     */
    public MyInteger(int value) {
        this.value = value;
    }

    /**
     * Getter for value
     */
    public int getValue() {
        return value;
    }


    /**
     * Determine if the value is even.
     */
    public static boolean isEven(int someValue) {
        return (someValue % 2) == 0;
    }

    /**
     * Determine if the value is even.
     */
    public static boolean isEven(MyInteger someValue) {
        return MyInteger.isEven(someValue.getValue());
    }

    /**
     * Determine if the value is even.
     */
    public boolean isEven() {
        return MyInteger.isEven(value);
    }

    /**
     * Determine if the value is odd
     */
    public static boolean isOdd(int someValue) {
        return ! MyInteger.isEven(someValue);
    }


    /**
     * Determine if the integer is prime
     */
    public static boolean isPrime(int someValue) {
        // determine if it is prime by dividing it by possible factors
        // until we get to half of its value or a factor is evenly divisible.

        // for each factor from 2 up to someValue/2
        for (int factor = 2; factor < someValue/2; factor++) {
            // if someValue % factor is evenly divisible then NOT PRIME!
            if (someValue % factor == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
    /**
     * Determine if the integer is prime
     */
    public boolean isPrime() {
        return MyInteger.isPrime(value);
    }
}