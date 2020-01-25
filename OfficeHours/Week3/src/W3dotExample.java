
import java.util.Random;

/**
 * This program picks a random card from a deck of 52 playing cards.
 * <ul>It will demonstrate
 *  <li>the generation of random numbers within a specific range</li>
 *  <li>the use of the modulo operator (%)</li>
 *  <li>if-else ladder</li>
 *  <li>switch statement</li>
 *  </ul>
 */
public class W3dotExample {
    public static void main(String[] args) {
        // Output the program description
        System.out.println("This program generates a random card from a deck of cards.");
        System.out.println();

        // Create our random number generator
        Random randomGenerator = new Random();

        // Generate the random number for the suit (0-3)
        int suit = Math.abs(randomGenerator.nextInt());
        suit = suit % 4;

        // Generate the random number for the card (1-13)
        int card = Math.abs(randomGenerator.nextInt());
        card = 1 + (card % 13);

        // Convert the suit to a string description (Clubs, Diamonds, Hearts, Spades)
        String suitString;

        if (suit == 0) {
            suitString = "Clubs";
        } else if (suit == 1) {
            suitString = "Diamonds";
        } else if (suit == 2) {
            suitString = "Hearts";
        } else {
            suitString = "Spades";
        }

        // Convert the card to a string description (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King)
        String cardString;
        switch (card) {
            case 1:
                cardString = "Ace";
                break;
            case 11:
                cardString = "Jack";
                break;
            case 12:
                cardString = "Queen";
                break;
            case 13:
                cardString = "King";
                break;
            default:
                cardString = String.valueOf(card);
        }

        // Print out the card
        System.out.format("%s of %s\n", cardString, suitString);
    }
}
