import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors
{
    static String playRound(String playerMove, String computerMove)
    {
        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String moves[] = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++)
        {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper or Scissors: ");
            String playerMove = sc.next();

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            System.out.println("Computer Move: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("FINAL SCOREBOARD");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");
    }
}
