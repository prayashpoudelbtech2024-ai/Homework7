import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] b = {'1','2','3','4','5','6','7','8','9'};
        char player = 'X';
        int move;

        for (int i = 0; i < 9; i++) {

            System.out.println("| " + b[0] + " | " + b[1] + " | " + b[2] + " |");
            System.out.println("| " + b[3] + " | " + b[4] + " | " + b[5] + " |");
            System.out.println("| " + b[6] + " | " + b[7] + " | " + b[8] + " |");

            System.out.print("Player " + player + " enter slot: ");
            move = sc.nextInt();

            if (b[move - 1] == 'X' || b[move - 1] == 'O') {
                System.out.println("Already filled! Try again.");
                i--;
                continue;
            }

            b[move - 1] = player;

            if ((b[0]==b[1] && b[1]==b[2]) ||
                (b[3]==b[4] && b[4]==b[5]) ||
                (b[6]==b[7] && b[7]==b[8])) {

                System.out.println("Player " + player + " wins!");
                break;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}