import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};

        while (true) {
            System.out.print("Enter Rock, Paper, Scissors or Quit: ");
            String user = sc.nextLine();

            if (user.equalsIgnoreCase("Quit")) {
                System.out.println("Game Ended");
                break;
            }

            String computer = choices[rand.nextInt(3)];
            System.out.println("Computer chose: " + computer);

            if (user.equalsIgnoreCase(computer)) {
                System.out.println("It's a Tie!");
            } else if (
                (user.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
                (user.equalsIgnoreCase("Scissors") && computer.equals("Paper")) ||
                (user.equalsIgnoreCase("Paper") && computer.equals("Rock"))
            ) {
                System.out.println("You Win!");
            } else {
                System.out.println("Computer Wins!");
            }
        }
    }
}