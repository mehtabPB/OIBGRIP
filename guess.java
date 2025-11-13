import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int rounds = 3;
        int attemptsPerRound = 5;
        int totalScore = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("-----------------------------------------");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int roundScore = 100;
            boolean guessed = false;

            System.out.println("\nRound " + round + " of " + rounds);
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

            while (attempts < attemptsPerRound) {
                System.out.print("Enter your guess: ");
                
                // Validate numeric input
                if (!input.hasNextInt()) {
                    System.out.println("⚠️ Please enter a valid number!");
                    input.next(); // clear invalid input
                    continue;
                }

                int guess = input.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed it in " + attempts + " attempts!");
                    roundScore -= (attempts * 10);
                    System.out.println("🏆 Your round score: " + roundScore);
                    guessed = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("😢 Out of attempts! The correct number was " + numberToGuess + ".");
            }

            totalScore += roundScore;
        }

        System.out.println("\n-----------------------------------------");
        System.out.println("🏁 Game Over! Your total score: " + totalScore);
        System.out.println("Thanks for playing! 😊");

        input.close();
    }
}
