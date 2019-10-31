/**
 * Implement the Rock/Paper/Scissors game
 */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors_Original {

    public static void main(String[] argv) {

        Random randomGenerator = new Random(System.currentTimeMillis());

        final int SCISSOR = 0;
        final int ROCK = 1;
        final int PAPER = 2;
        final int MINVALUE = SCISSOR;
        final int MAXVALUE = PAPER;

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

            // Generate the description of the inputs
            String userChoiceString = "";

            switch (userChoice) {
                case SCISSOR:
                    userChoiceString = "scissor";
                    break;
                case ROCK:
                    userChoiceString = "rock";
                    break;
                case PAPER:
                    userChoiceString = "paper";
            }

            String computerChoiceString = "";

            switch (computerChoice) {
                case SCISSOR:
                    computerChoiceString = "scissor";
                    break;
                case ROCK:
                    computerChoiceString = "rock";
                    break;
                case PAPER:
                    computerChoiceString = "paper";
            }

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
    }

}
