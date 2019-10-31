import java.util.Scanner;

/**
 * Print out the phonetic alphabet.
 * Write a program that prompts the user for a letter of the alphabet
 * and prints out the phonetic alphabet value for that letter.
 */
public class Alphabet {

    private static String[] alphabet = new String[] {
        "Alpha",            // 0
        "Bravo",            // 1
        "Charlie",          // 2
        "Delta",            // 3
        "Echo",             // 4
        "Foxtrot",          // 5
        "Golf",             // 6
        "Hotel",            // 7
        "India",            // 8
        "Juliet",           // 9
        "Kilo",             // 10
        "Lima",             // 11
        "Mike",             // 12
        "November",         // 13
        "Oscar",            // 14
        "Papa",             // 15
        "Quebec",           // 16
        "Romeo",            // 17
        "Sierra",           // 18
        "Tango",            // 19
        "Uniform",          // 20
        "Victor",           // 21
        "Whiskey",          // 22
        "XRay",             // 23
        "Yankee",           // 24
        "Zulu"              // 25
    };


    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            // prompt the user to input a letter of the alphabet
            System.out.print("Enter a letter of the alphabet: ");

            String letterString = input.nextLine();
            if (letterString == null
                    || letterString.trim().length() == 0) {
                System.err.println("You have to enter something!");
                System.exit(1);
            }

            // get the first character out of the string. It's all
            // we care about.
            char letter = letterString.toUpperCase().charAt(0);

            if (Character.isDigit(letter)) {
                System.err.println("Only letters are valid");
                System.exit(1);
            }

            // Find corresponding phonetic word for the letter.
            // subtract the numeric value of 'A' from the letter
            // to convert it to an array index, starting at 0
            int index = letter - 'A'; //65;
            String phonetic = alphabet[index];

            // Print it out.
            System.out.println(phonetic);
        }

    }

}
