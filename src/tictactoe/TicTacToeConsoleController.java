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
  private int getNextInt(Scanner scan, Appendable out, TicTacToeModel m) {

    if (scan.hasNextInt()) {
      return scan.nextInt() - 1;
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

    try {
      while (!m.isGameOver()) {

        if (scan.hasNext("q")) {
          out.append("Game quit! Ending game state:\n")
              .append(m.toString());
          return;
        }

        out.append(m.toString());
        out.append("\nEnter a move for ");
        out.append(m.getTurn().toString());
        out.append(":\n");



        if (scan.hasNextInt()) {
          row = scan.nextInt() - 1;
          if (scan.hasNextInt()) {
            col = scan.nextInt() - 1;
          } else {
            // 需要判断还有没有参数
            if (scan.hasNext()) {
              if (scan.hasNext("q")) {
                out.append("Game quit! Ending game state:\n")
                    .append(m.toString());
                return;
              } else {
                out.append("Not a valid number: ")
                    .append(scan.next())
                    .append("\n");
              }
            } else {
              // 没有下一个参数
              return;
            }
            continue;
          }
        } else {
          if (scan.hasNext()) {
            if (scan.hasNext("q")) {
              out.append("Game quit! Ending game state:\n")
                  .append(m.toString());
              return;
            } else {
              out.append("Not a valid number: ")
                  .append(scan.next())
                  .append("\n");
              continue;
            }

          } else {
            // 没有下一个参数
            return;
          }
        }

        try {
          m.move(row, col);
        } catch (RuntimeException e) {
          out.append("Not a valid move: ")
              .append(String.valueOf(row + 1))
              .append(", ")
              .append(String.valueOf(col + 1))
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
