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

  // -1 game ends, -2 not a valid number continue, -3 no next input parameter
  private int getNextInt(Scanner scan, Appendable out, TicTacToe m) {

    if (scan.hasNextInt()) {
      int tmp = scan.nextInt();
      if (tmp == 1 || tmp == 2 || tmp == 3) {
        return tmp -1;
      } else {
        return -2;
      }
    } else if (scan.hasNext()){
      try {
        if (scan.hasNext("q")) {
          out.append("Game quit! Ending game state:\n")
              .append(m.toString());
          return -1;
        } else {
          out.append("Not a valid number: ")
              .append(scan.next())
              .append("\n");
          return -2;
        }
      } catch (IOException ioe) {
        throw new IllegalStateException("Append failed", ioe);
      }

    } else {
      return -3;
    }
  }

  @Override
  public void playGame(TicTacToe m) {
    int row = -1;
    int col = -1;
    int[] values;
    int cnt;

    try {
      while (!m.isGameOver()) {
        cnt = 0;
        values = new int[2];

        if (scan.hasNext("q")) {
          out.append("Game quit! Ending game state:\n")
              .append(m.toString());
          return;
        }

        out.append(m.toString());
        out.append("\nEnter a move for ");
        out.append(m.getTurn().toString());
        out.append(":\n");

        while (cnt < 2) {
          int tmp = getNextInt(scan, out, m);
          switch (tmp) {
            case -1:
              return;
            case -3:
              return;
            case -2:
              continue;
            default:
              values[cnt] = tmp;
              cnt += 1;
          }
        }

        try {
          m.move(values[0], values[1]);
        } catch (RuntimeException e) {
          out.append("Not a valid move: ")
              .append(String.valueOf(values[0] + 1))
              .append(", ")
              .append(String.valueOf(values[1] + 1))
              .append('\n');
        }

      }

      out.append(m.toString());
      out.append("\n");
      out.append("Game is over! ");
      if (m.getWinner() == null) {
        out.append("Tie game.");
      } else {
        out.append(m.getWinner().toString());
        out.append(" wins.");
      }

    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }

    System.out.println(out);
  }

}
