/**
 * MyInteger class to model some operation of integers.
 */
public class MyInteger {

    private int value;

    /**
     * Create a new MyInteger object with the given value.
     *
     * @param value
     */
    public MyInteger(int value) {
        this.value = value;
    }

    /**
     * Returns the value held in this object.
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Test if the value is even
     *
     * @return
     */
    public boolean isEven() {
        return isEven(value);
    }

    /**
     * Test if the value is odd
     *
     * @return
     */
    public boolean isOdd() {
        return isOdd(value);
    }

    /**
     * Test if the value is prime.
     *
     * @return
     */
    public boolean isPrime() {
        return isPrime(value);
    }

    /**
     * Test if the value is even
     *
     * @return
     */
    public static boolean isEven(int intVal) {
        return intVal % 2 == 0;
    }

    /**
     * Test if the value is odd
     *
     * @return
     */
    public static boolean isOdd(int intVal) {
        return intVal % 2 != 0; // Faster

        // A bit slower, but maybe worth it if the logic is complex.
        // return ! isEven(intVal);
    }

    /**
     * Test if the value is prime.
     *
     * @return
     */
    public static boolean isPrime(int intVal) {
        for (int i = 2; i < intVal / 2; i++) {
            if (intVal % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Test if the value is even
     *
     * @return
     */
    public static boolean isEven(MyInteger intVal) {
        return isEven(intVal.getValue());
    }

    /**
     * Test if the value is odd
     *
     * @return
     */
    public static boolean isOdd(MyInteger intVal) {
        return isOdd(intVal.getValue());
    }

    /**
     * Test if the value is prime.
     *
     * @return
     */
    public static boolean isPrime(MyInteger intVal) {
        return isPrime(intVal.getValue());
    }

    /**
     * Test if the current value equals the specified value.
     *
     * @param otherVal
     * @return
     */
    public boolean equals(int otherVal) {
        return value == otherVal;
    }

    /**
     * Test if the current value equals the specified value.
     *
     * @param otherVal
     * @return
     */
    public boolean equals(MyInteger otherVal) {
        // return value == otherVal.getValue(); // a bit faster

        // a bit slower, but just as good
        return equals(otherVal.getValue());
    }

    /**
     * Parse and return the integer represented by the array of characters.
     *
     * @param data
     * @return
     */
    public static int parseInt(char[] data) {
        String strData = new String(data);
        return parseInt(strData);
    }

    /**
     * Parse and return the integer represented by the String.
     *
     * @param data
     * @return
     * @throws NumberFormatException
     */
    public static int parseInt(String data) throws NumberFormatException {
        return Integer.parseInt(data);
    }
}
