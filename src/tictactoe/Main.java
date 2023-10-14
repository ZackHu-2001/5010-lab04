package tictactoe;

import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Run a TicTacToe game interactively on the console.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively on the console.
   */
  public static void main(String[] args) {
    Readable input = new InputStreamReader(System.in);
    Appendable output = System.out;
    new TicTacToeConsoleController(input, output).playGame(new TicTacToeModel());
  }
}


