import java.util.Random;
import java.util.Scanner;


public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 10;
        int currentRound = 1;
        int totalAttempts = 0;
        int roundsWon = 0;
        
        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("Round " + currentRound);
            
            int attempts = 0;
            while (attempts < attemptsLimit) {
                System.out.print("Guess the number between " + lowerBound + " and " + upperBound + ": ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;
                
                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                }
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
            currentRound++;
        }
        
        System.out.println("Game Over");
        System.out.println("Rounds played: " + (currentRound - 1));
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts made: " + totalAttempts);
        
        scanner.close();
    }
}

