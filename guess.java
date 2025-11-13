import random

def number_guessing_game():
    rounds = 3
    attempts_per_round = 5
    total_score = 0

    for round_num in range(1, rounds + 1):
        number_to_guess = random.randint(1, 100)
        round_score = 100
        attempts = 0

        print(f"\nRound {round_num} of {rounds}")
        print("I'm thinking of a number between 1 and 100. Can you guess it?")

        while attempts < attempts_per_round:
            try:
                guess = int(input("Enter your guess: "))
            except ValueError:
                print("Please enter a valid number!")
                continue

            attempts += 1

            if guess == number_to_guess:
                print(f"🎉 Congratulations! You guessed it in {attempts} attempts!")
                round_score -= (attempts * 10)
                print(f"Your round score: {round_score}")
                break
            elif guess < number_to_guess:
                print("Too low! Try again.")
            else:
                print("Too high! Try again.")

        if attempts == attempts_per_round and guess != number_to_guess:
            print(f"😢 Out of attempts! The correct number was {number_to_guess}.")

        total_score += round_score

    print(f"\n Game Over! Your total score: {total_score}")

if __name__ == "__main__":
    number_guessing_game()
