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
//    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    //[2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2]
    Appendable output = System.out;
    new TicTacToeConsoleController(input, output).playGame(new TicTacToeModel());
  }
}
