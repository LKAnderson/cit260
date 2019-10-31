/**
 * Implement the Rock/Paper/Scissors game
 */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    final static int SCISSOR = 0;
    final static int ROCK = 1;
    final static int PAPER = 2;
    final static int MINVALUE = SCISSOR;
    final static int MAXVALUE = PAPER;
    final static int INVALID_CHOICE = -1;


    /**
     * Convert user's choice to a string
     * @param choice
     * @return The string corresponding to the choice passed in.
     */
    public static String choiceConverter(int choice) {
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
            default:
                choiceString = "Hey, give us a real choice value";
        }

        return choiceString;
    }

    /**
     * Get the user's input
     * @param scanner
     * @return The user's choice or INVALID_CHOICE if invalid.
     */
    public static int getUserChoice(Scanner scanner) {
        // Ask the user to enter 0, 1, 2 (rock, paper, scissors)
        System.out.print("scissor (0), rock (1), paper (2): ");
        int userChoice = scanner.nextInt();

        if (userChoice < MINVALUE || userChoice > MAXVALUE) {
            return INVALID_CHOICE;
        }

        return userChoice;
    }

    /**
     * Run the complex logic of our game, and print out the winner.
     * @param userChoice
     * @param computerChoice
     */
    public static void runGameLogic(int userChoice, int computerChoice) {

        // Generate the description of the inputs
        String userChoiceString = choiceConverter(userChoice);
        String computerChoiceString = choiceConverter(computerChoice);

        // Start to print out the report
        System.out.format("The computer chose %s. You chose %s", computerChoiceString, userChoiceString);

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
     * Our main method.
     * @param argv
     */
    public static void main(String[] argv) {

        // Initialize our random number generator.
        Random randomGenerator = new Random(System.currentTimeMillis());

        try (Scanner scanner = new Scanner(System.in)) {

            // Get the user's inputs
            int userChoice = getUserChoice(scanner);

            if (userChoice == INVALID_CHOICE) {
                System.err.println("Invalid input");
                System.exit(1);
            }

            // Ask the computer pick 0, 1, 2 (rock, paper, scissors)
            int computerChoice = randomGenerator.nextInt(MAXVALUE + 1);

            // Run the logic and end the game when it returns.
            runGameLogic(userChoice, computerChoice);
        }
    }

}
