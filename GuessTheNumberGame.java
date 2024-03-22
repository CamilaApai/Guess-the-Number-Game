
// Allows to get a random generated number
import java.util.Random;
// Allows to get user input
import java.util.Scanner;

// The applciation must begin with a class name that must match the file name.
public class GuessTheNumberGame {
    // Returns a random number between 1 to 100.
    static int randomNumber = (int) (Math.random() * 100);
    static int attempts = 5;
    static boolean gameOver = false;
    int guessNumber;

    static void startGame() {
        // Prints introducing lines of text for the user to the screen.
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("Guess a number between 1 to 100");
        System.out.println("You have " + attempts + " attempts");
    }

    // Generates a random number between 1 to 100
    public static int getRandomNumber() {
        Random randomNumber = new Random();
        int random = randomNumber.nextInt(100) + 1;
        return random;
    };


    // Prompt the user for input and store the guess
    public static int getUserInput() {
        try (// Create a Scanner object
               Scanner userInput = new Scanner(System.in)) {
            System.out.println("Type a number: ");
            return userInput.nextInt();
        }
    }

    
    // Checks if the user still has attempts left
    static void checkAttempts(int attempts) {
        while (attempts > 0) {
            System.out.println("Type a number: ");
            if (attempts < 1) {
                attempts--;
                System.out.println("You run out of attempts");
                break;
            }
            return;
        }
    }


    // Check the guess against the random number
    static void checkNumber(int guessNumber) {
        if (randomNumber > guessNumber) {
            System.out.println("The number should be higher");
        } else if (randomNumber < guessNumber) {
            System.out.println("The number should be lower");
        } else {
            System.out.println("That's the correct number, congratulations!");
        }
    }

    // Every program must contain the main method, the code inside of it will be executed.
    public static void main(String[] args) {
        startGame();
        int guessNumber = getUserInput(); 
        checkNumber(guessNumber); 
    }
}
