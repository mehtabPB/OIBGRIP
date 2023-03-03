import java.util.Scanner;
import java.util.Random;

class guess{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int rounds = 3; // number of rounds
        int attemptsPerRound = 5; // number of attempts per round
        int totalScore = 0; // keep track of total score

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = rand.nextInt(100) + 1; // generate a random number between 1 and 100
            int guess;
            int attempts = 0; // keep track of the number of attempts
            int roundScore = 100; //initialize score for each round

            System.out.println("Round " + round + " of " + rounds + ": ");
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

            while (attempts < attemptsPerRound) {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();
                attempts++; // increment the number of attempts

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                    roundScore = roundScore - (attempts*10); // decrease score based on attempts
                    System.out.println("Your round score is: " + roundScore);
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if(attempts == attemptsPerRound) {
                System.out.println("Sorry you have exceeded the number of attempts");
            }
            totalScore += roundScore;
        }
        System.out.println("Your total score is: " + totalScore);
    }
}