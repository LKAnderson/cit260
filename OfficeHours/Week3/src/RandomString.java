/**
 * Write a program that prints one of five strings. The
 * string should be selected at random.
 */

import java.util.Random;

public class RandomString {

    public static void main(String[] args) {

        // Generate a random number between 0 and 5 (not including 5)
        var random = new Random();
        var randomNumber = Math.abs(random.nextInt());

        // pick a string based on the random number
        String str = null;

        switch (randomNumber % 5) {
            case 0:
                str = "This is the first string";
                break;
            case 1:
                str = "This is the second string";
                break;
            case 2:
                str = "This is the third string";
                break;
            case 3:
                str = "This is the fourth string";
                break;
            case 4:
                str = "This is the fifth string";
                break;
        }

        // Print it out
        System.out.println(str);
    }
}
