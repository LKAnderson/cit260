package assignments;

public class A12dot2 {

    /**
     * Main method of the program.
     * @param argv
     */
    public static void main(String[] argv) {

        UserInput.setInputStream(System.in);
        
        // Get the values
        int value1 = UserInput.getInteger("Enter first integer: ");
        int value2 = UserInput.getInteger("Enter second integer: ");

        // Report the result.
        System.out.printf("%d + %d = %d%n", value1, value2, value1 + value2);
    }


}