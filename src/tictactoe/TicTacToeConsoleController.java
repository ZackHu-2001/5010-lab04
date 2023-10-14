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

  // -2 game ends, -3 not a valid number continue, -4 no next input parameter
  private int getNextInt(Scanner scan, Appendable out, TicTacToe m) {

    if (scan.hasNextInt()) {
      return scan.nextInt() - 1;
    } else if (scan.hasNext()) {
      try {
        if (scan.hasNext("q")) {
          out.append("Game quit! Ending game state:\n")
              .append(m.toString());
          return -2;
        } else {
          out.append("Not a valid number: ")
              .append(scan.next())
              .append("\n");
          return -3;
        }
      } catch (IOException ioe) {
        throw new IllegalStateException("Append failed", ioe);
      }

    } else {
      return -4;
    }
  }

  @Override
  public void playGame(TicTacToe m) {
    int[] values;
    int cnt;

    if (m == null) {
      throw new IllegalArgumentException("Invalid model.");
    }

    try {
      out.append(m.toString());
      out.append("\nEnter a move for ");
      out.append(m.getTurn().toString());
      out.append(":\n");

      while (!m.isGameOver()) {
        cnt = 0;
        values = new int[2];

        if (scan.hasNext("q")) {
          out.append("Game quit! Ending game state:\n")
              .append(m.toString());
          return;
        }

        while (cnt < 2) {
          int tmp = getNextInt(scan, out, m);
          switch (tmp) {
            case -2:
              return;
            case -4:
              return;
            case -3:
              continue;
            default:
              values[cnt] = tmp;
              cnt += 1;
          }
        }

        try {
          m.move(values[0], values[1]);
        } catch (IllegalArgumentException e) {
          out.append("Not a valid move: ")
              .append(String.valueOf(values[0] + 1))
              .append(", ")
              .append(String.valueOf(values[1] + 1))
              .append('\n');
          continue;
        }

        if (!m.isGameOver()) {
          out.append(m.toString());
          out.append("\nEnter a move for ");
          out.append(m.getTurn().toString());
          out.append(":\n");
        } else {
          break;
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

  }

}
