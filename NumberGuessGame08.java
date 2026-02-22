import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame08 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int number = rand.nextInt(100) + 1;
        int attempts = 5;

        System.out.println("Guess a number between 1 and 100");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": ");
            int guess = sc.nextInt();

            if (guess > number) {
                System.out.println("Too High!");
            } else if (guess < number) {
                System.out.println("Too Low!");
            } else {
                System.out.println("Correct! You Win!");
                return;
            }
        }

        System.out.println("Game Over! The number was " + number);
    }
}