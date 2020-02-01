/**
 * Convert a user's input character to its phonetic alphabet
 * equivalent.
 */

import java.util.Scanner;

public class W4dotExample {

    // lookup table for characters
    private static final String[] phoneticCharacters = {
            "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf",
            "Hotel", "India", "Juliet", "Kilo", "Lima", "Mike", "November",
            "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
            "Victor", "Whiskey", "Xray", "Yankee", "Zulu"
    };

    // lookup table for digits
    private static final String[] phoneticDigits = {
            "Zero", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Niner"
    };

    public static void main(String[] args) {

        System.out.println("This program converts characters and digits to their");
        System.out.println("phonetic alphabet equivalents.");
        System.out.println();

        try (Scanner input = new Scanner(System.in)) {
            // Prompt the user for a character of input (they may accidentally enter more than 1)
            System.out.print("Please enter a character or digit: ");
            String userInput = input.nextLine().trim().toUpperCase();

            // Validate that the user's input is a character or a digit.
            if (userInput.length() == 0) {
                System.err.println("Please enter a value.");
                return;
            }

            char userChar = userInput.charAt(0);
            String phoneticValue = null;

            // Check for valid input and
            // Convert the character to its numeric index value
            if (userChar >= '0' && userChar <= '9' ) {
                int index = userChar - '0';
                phoneticValue = phoneticDigits[index];

            } else if (userChar >= 'A' && userChar <= 'Z' ) {
                int index = userChar - 'A';
                phoneticValue = phoneticCharacters[index];

            } else {
                System.err.println("Your input is not a valid character.");
                return;
            }

            // Print it out.
            System.out.println("Your character is " + phoneticValue);
        }

        System.out.println();
        System.out.println("Good-bye.");
    }
}