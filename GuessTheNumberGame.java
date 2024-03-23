
import java.util.Random; // Allows to get a random generated number
import java.util.Scanner; // Allows to get user input

public class GuessTheNumberGame {
    // Declare private variables to store the random number and the number of attempts
    private int random;
    private int attempts = 10;

    public GuessTheNumberGame() {
        Random randomNumber = new Random(); // An instance of the Random class is created.
        random = randomNumber.nextInt(100) + 1; // Generates a random integer between 0 and 100
    }

    public void startGame() {
        // Prints introducing lines of text for the user to the screen.
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("Guess a number between 1 to 100");
        System.out.println("You have " + attempts + " attempts");
        System.out.println("");

        try (Scanner userInput = new Scanner(System.in)) { // Creates a Scanner object
            while (attempts > 0) {
                System.out.print("Type a number: ");
                int guessNumber = userInput.nextInt(); // Read the user's input as an integer
                if (checkNumber(guessNumber)) {
                    break; // Exit the loop if the guess is correct
                }
                attempts--; // Decrement the number of remaining attempts
                System.out.println("You have " + attempts + " attempts left");
                System.out.println("");
            }
        }
        // Check if the user has run out of attempts
        if (attempts == 0) {
            System.out.println("You ran out of attempts. The correct number was " + random);
        }
    }

    // Compare the user guessed number with the generated random number, and provide feedback to the user based on that.
    private boolean checkNumber(int guessNumber) {
        if (guessNumber == random) {
            System.out.println("That's the correct number, congratulations!");
            return true; // Returns true if the guessed number matches the random number
        } else if (guessNumber < random) {
            System.out.println("The number should be higher");
        } else {
            System.out.println("The number should be lower");
        }
        return false; // Returns false if the guessed number dosen´t match the random number
    }

    // Every program must contain the main method, the code inside of it will be executed.
    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.startGame();
    }
}
