package officehours;

import java.util.Scanner;

public class VowelsOrConsonants {
    
    public static void main(String[] argv) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Ask the user for the input
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine();
            
            if (input.length() < 1) {
                System.err.println("Invalid input");
                System.exit(1);
            }
            
            char inputChar = input.charAt(0);
            
            // Check for valid input
            char upperChar = Character.toUpperCase(inputChar);
            if (upperChar < 'A' || upperChar > 'Z') {
                System.err.println("Invalid input");
                System.exit(1);
            }
            
            // Determine if it's a consonant or a vowel
            boolean isVowel = false;
            
            switch (upperChar) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
                isVowel = true;
                break;
            }
            
            // Print the results
            System.out.printf("%s is a %s\n", inputChar, 
                    isVowel == true ? "vowel" : "consonant");
            
            if (upperChar == 'Y') {
                System.out.println("(sometimes)");
            }
            
        }
        
    }

}
