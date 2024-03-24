import java.util.Random; // Allows to get a random generated number
import java.util.Scanner; // Allows to get user input
import java.util.ArrayList; // Allows to get an array with all of the user guesses

// Define the game interface
interface Game {
    public void startGame();
    public boolean checkNumber(int guessNumber);
}

// Implement the Game interface in GuessTheNumberGame class
public class GuessTheNumberGame implements Game {
    /*
     * Declare private variables to store the random number, the number of attempts,
     * an array with all of the user guesses and the scanner
     */
    private int random;
    private int attempts = 10;
    private ArrayList<Integer> guesses = new ArrayList<>();
    private Scanner userInput;

    public GuessTheNumberGame() {
        Random randomNumber = new Random(); // An instance of the Random class is created.
        random = randomNumber.nextInt(100) + 1; // Generates a random integer between 1 and 100
        userInput = new Scanner(System.in); // Initialize Scanner
    }

    public void startGame() {
        // Prints introducing lines of text for the user to the screen.
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("Guess a number between 1 to 100");
        System.out.println("You have " + attempts + " attempts");
        System.out.println("");

        boolean playAgain = true; // Initialize playAgain variable to true
        while (playAgain) { // Loop to allow playing again
            try {
                while (attempts > 0) {
                    System.out.print("Type a number: ");
                    try {
                        int guessNumber = userInput.nextInt(); // Read the user's input as an integer
                        guesses.add(guessNumber); // Store the user guess in the ArrayList
                        if (checkNumber(guessNumber)) {
                            break; // Exit the loop if the guess is correct
                        }
                        attempts--; // Decrement the number of remaining attempts
                        System.out.println("You have " + attempts + " attempts left");
                        System.out.println("Guess History: " + guesses); // Shows the history of user guesses.
                        System.out.println("");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        userInput.next(); // Clear the input buffer
                    }
                }
                // Check if the user has run out of attempts
                if (attempts == 0) {
                    System.out.println("You ran out of attempts. The correct number was " + random);
                }

                /*
                 * Ask the user if they want to play again, if the answer is "yes"
                 * the variables are reset and the game starts again
                 */
                System.out.print("Do you want to play again? (Y/N): ");
                String playAgainResponse = userInput.next(); // Read the user's input as a string
                playAgain = playAgainResponse.equalsIgnoreCase("Y");
                if (playAgain) { // Reset game variables if user wants to play again
                    attempts = 10;
                    random = new Random().nextInt(100) + 1;
                    guesses.clear();
                }
            }
            /*
             * If an exception occurs while executing the "try" block,
             * the following code will be executed
             */
            catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                userInput.next(); // Clear the input buffer
            }
        }
        System.out.println("Thank you for playing!");
        userInput.close(); // Close the Scanner
    }

    /*
     * Compare the user guessed number with the generated random number,
     * and provide feedback to the user based on that.
     */
    public boolean checkNumber(int guessNumber) {
        if (guessNumber == random) {
            System.out.println("That's the correct number, congratulations!");
            return true; // Returns true if the guessed number matches the random number
        } else if (guessNumber < random) {
            System.out.println("The number should be higher");
        } else {
            System.out.println("The number should be lower");
        }
        return false; // Returns false if the guessed number doesn't match the random number
    }

    // Every program must contain the main method, the code inside of it will be
    // executed.
    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.startGame();
    }
}
