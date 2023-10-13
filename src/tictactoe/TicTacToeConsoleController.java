package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the
 * TicTacToe MVC assignment.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   * 
   * @param in  the source to read from
   * @param out the target to print to
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe m) {
    int row = 0;
    int col = 0;

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
//

    try {
      while(scan.hasNextLine()) {
        out.append(scan.nextLine());
      }
//      while (!m.isGameOver()) {
////        out.append("Enter a move for ").append(String.valueOf(m.getTurn())).append(": \n");
//
//        if (scan.hasNextInt()) {
//          row = scan.nextInt();
//          if (scan.hasNextInt()) {
//            col = scan.nextInt();
//          } else {
//            out.append("Not a valid number: ").append(scan.next());
//            continue;
//          }
//        }
//
//        try {
//          m.move(row, col);
//        } catch (RuntimeException e) {
//          out.append(e.getMessage()).append('\n');
//          return;
//        }
//
//        //
//
//      }
////      String element = scan.next();
////      out.append("Hello world, " + element);
//
//      System.out.println("Game is over!");
//      if (m.getWinner() == null) {
//        System.out.println("Tie game.");
//      } else {
//        System.out.println(m.getWinner() + " wins.");
//      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }
    System.out.println(out);
  }

}
