/*
 * This is a program creates a random number 
 * that the user tries to guess
 *
 * @author  Curtis Edwards
 * @version 1.0
 * @since   2024-02-26
 */

import java.util.Scanner;
import java.util.Random;

/**
* This is the standard "NumberGuessing" program.
*/
final class NumberGuessing {

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private NumberGuessing() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(String[] args) {
        // constants & variables
        final Scanner scanner = new Scanner(System.in);
	Random random = new Random();
        final int randomNumber = random.nextInt(6) + 1;
        int totalGuesses = 0;
	int userGuessInt = 0;
        boolean validInput = false;

        while (true) {
            // input and error check
            try {
                System.out.print("Guess a number between 1 - 6: ");
                String userGuessString = scanner.nextLine().trim();
                if (userGuessString.isEmpty()) {
                    System.out.println("Invalid input. (This won’t count as a guess)\n");
                } else {
                    userGuessInt = Integer.parseInt(userGuessString);
                    validInput = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. (This won’t count as a guess)\n");
            }
            // process
            if (validInput) {
                if (userGuessInt > randomNumber) {
                    totalGuesses += 1;
                    System.out.println("You guessed too high, try again!\n");
                } else if (userGuessInt < randomNumber) {
                    totalGuesses += 1;
                    System.out.println("You guessed too low, try again!\n");
                } else {
                    // output
                    totalGuesses += 1;
                    System.out.println("Correct!\nTotal guesses: " + totalGuesses);
                    break;
                }
            }
        }
    System.out.println("\nDone.");
    }
}
