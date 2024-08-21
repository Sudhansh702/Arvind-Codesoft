import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.print("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();
        int score = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            int number = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1 to 100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + number);
                }
            }
        }

        System.out.println("\nGame Over! You won " + score + " out of " + rounds + " rounds.");
        System.out.print("Would you like to play again? (yes/no): ");
        String playAgain = scanner.next();

        if (playAgain.equalsIgnoreCase("yes")) {
            main(null); // Restart the game
        } else {
            System.out.println("Thanks for playing!");
        }

        scanner.close();
    }
}
