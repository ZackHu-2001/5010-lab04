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
//    Readable input = new InputStreamReader(System.in);
//    StringReader input = new StringReader("7.5 1 1 1 1 2 2 2 1 1 7 1 2 3 1");
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
//    StringReader input = new StringReader("0 1 1 1 2 2 3 3 2 2 hello 2 3 1 3 2 1");
    Appendable output = System.out;
    new TicTacToeConsoleController(input, output).playGame(new TicTacToeModel());
  }
}


//    2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2
//    1 1 2 2 1 3 1 2 3 3 1 3 q
//    1 1 2 2 1 3 1 2 3 3 3 2
//    2 2 1 2 1 1 2 1 3 3
//    1 1 2 2 1 3 2 q
//    0 1 1 1 2 2 3 3 2 2 hello 2 3 1 3 2 1
//    7.5 1 1 1 1 2 2 2 1 1 7 1 2 3 1
//    1 1 4 2 q
//    2 2 q
//    1 1 2 4 q
//    3 8.79 q
//    1 1 2 2 1 3 q
//    2 2 1 3 9 2 u 2 2 6 2 1 q
//    0 1 1 1 2 2 3 3 2 2 hello 2 3 1 3 2 1
//    1 1 2 2 1 1 1 2 1 3 5 2 3 1 2 1 fhgy 2 3 2 9 3 2 3 3
//    !#$ 2 q

