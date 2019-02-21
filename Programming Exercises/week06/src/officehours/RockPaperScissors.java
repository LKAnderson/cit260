package officehours;

import java.util.Scanner;

import java.util.Random;

public class RockPaperScissors {
    
    final static int SCISSOR = 0;
    final static int ROCK = 1;
    final static int PAPER = 2;
    final static int MINVALUE = SCISSOR;
    final static int MAXVALUE = PAPER;
    
    
    /**
     * Get the description of the user's choice.
     * @param choice
     * @return The description
     */
    public static String getChoiceString(int choice) {
        
        String choiceString = null;
        
        switch (choice) {
            case SCISSOR:
                choiceString = "scissor";
                break;
            case ROCK:
                choiceString = "rock";
                break;
            case PAPER:
                choiceString = "paper";
                break;
        }
        
        return choiceString;
    }
    
    
    /**
     * Calculate the winner and print the result.
     * @param userChoice
     * @param computerChoice
     */
    public static void printResult(int userChoice, int computerChoice) {
        
        String userChoiceString = getChoiceString(userChoice);            

        String computerChoiceString = getChoiceString(computerChoice);

        // Start to print out the report
        System.out.printf("The computer chose %s. You chose %s", computerChoiceString, userChoiceString);


        
        if (userChoice == computerChoice) {
            System.out.print(", too. It is a draw.");
        } else if (userChoice == PAPER && computerChoice == SCISSOR) {
            System.out.println(". The computer won.");
        } else if (computerChoice == PAPER && userChoice == SCISSOR) {
            System.out.println(". You won.");
        } else if (userChoice > computerChoice) {
            System.out.println(". You won.");
        } else {
            System.out.println(". The computer won.");
        }
    }
    

    /**
     * Main. 'nuff said
     * @param argv
     */
    public static void main(String[] argv) {

        Random randomGenerator = new Random(System.currentTimeMillis()); 

        try (Scanner scanner = new Scanner(System.in)) {

            // Ask the user to enter 0, 1, 2 (rock, paper, scissors)
            System.out.print("scissor (0), rock (1), paper (2): ");
            int userChoice = scanner.nextInt();

            if (userChoice < MINVALUE || userChoice > MAXVALUE) {
                System.err.println("Invalid input");
                System.exit(1);
            }

            // Ask the computer pick 0, 1, 2 (rock, paper, scissors)
            int computerChoice = randomGenerator.nextInt(MAXVALUE + 1);
            
            
            printResult(userChoice, computerChoice);

        }
    }

}
