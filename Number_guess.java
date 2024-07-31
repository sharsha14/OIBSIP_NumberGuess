import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int rounds = 3; // Number of rounds
        int maxAttempts = 5; // Maximum attempts per round
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = rand.nextInt(100) + 1; // Generates a number between 1 and 100
            int numberOfTries = 0;
            boolean win = false;

            System.out.println("\nRound " + round + " of " + rounds);
            System.out.println("Try to guess the number between 1 and 100.");

            while (numberOfTries < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfTries++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    win = true;
                    totalScore += (maxAttempts - numberOfTries + 1); // Points based on remaining attempts
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!win) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess);
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your total score: " + totalScore);
        scanner.close();
    }
}
