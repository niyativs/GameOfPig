import java.util.Scanner;

public class GameOfPig {

  static int player_score = 0;
  static int comp_score = 0;
  static int playerTurnScore;
  static int compTurnScore;

  public static void main(String args[]) {

    do {
      GameOfPig.playerTurnChoice();
      GameOfPig.compTurnChoice();
    } while (player_score < 100 || comp_score < 100);

    if (player_score >= 100) {
      System.out.println("You win!");
    } else {
      System.out.println("You lose!");
    }
  }

  public static void compTurnChoice() {

    double choice = Math.random();

    if (choice < 0.3) {
      System.out.println("Computer held");
      return;
    } else {
      GameOfPig.compRoll();
    }
    return;
  }

  private static void compRoll() {
    int diceOne = (int) ((Math.random() * 6) + 1);
    int diceTwo = (int) ((Math.random() * 6) + 1);

    if (diceOne == 1 || diceTwo == 1) {
      compTurnScore = 1;
    } else if (diceOne == 1 && diceTwo == 1) {
      return;
    } else if (diceOne == diceTwo && diceOne != 1) {
      compTurnScore = ((diceOne + diceTwo) * 2);
      GameOfPig.compTurnChoice();
    } else {
      compTurnScore = (diceOne + diceTwo);
      GameOfPig.compTurnChoice();
    }
    comp_score = comp_score + compTurnScore;
    System.out.println("The computer’s score is: " + comp_score);

    return;

  }

  private static void playerRoll() {
    int diceOne = (int) ((Math.random() * 6) + 1);
    int diceTwo = (int) ((Math.random() * 6) + 1);

    System.out.println("Your dice rolled " + diceOne + " and " + diceTwo);

    if (diceOne == 1 || diceTwo == 1) {
      playerTurnScore = 1;
    } else if (diceOne == 1 && diceTwo == 1) {
      return;
    } else if (diceOne == diceTwo && diceOne != 1) {
      playerTurnScore = ((diceOne + diceTwo) * 2);
      GameOfPig.playerTurnChoice();
    } else {
      playerTurnScore = (diceOne + diceTwo);
      GameOfPig.playerTurnChoice();
    }
    player_score = playerTurnScore + player_score;
    System.out.println("Your score is: " + player_score);

    return;
  }

  private static void playerTurnChoice() {
    Scanner holdOrRoll = new Scanner(System.in);
    System.out.println("Enter 1 to hold and 2 to roll");
    int choice = holdOrRoll.nextInt();
    if (choice == 1) {
      return;
    } else {
      GameOfPig.playerRoll();
    }
    return;

  }

}
