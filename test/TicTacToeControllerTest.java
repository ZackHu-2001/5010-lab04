import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import org.junit.Test;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and
 * appendable.
 */
public class TicTacToeControllerTest {

  // Providing this shell for you to write your
  // own test cases for the TicTacToe controller
  // You DO NOT NEED to implement tests for the provided model
  
  // TODO: Implement your own tests cases for the controller

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidModel() {
    TicTacToe m = null;
    StringReader input = new StringReader("1 1 4 1 q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
  }

  @Test
  public void testRowOutOfBound() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 4 1 q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + "Not a valid move: 4, 1\n" 
        + "Game quit! Ending game state:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());
  }

  @Test
  public void testColOutOfBound() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 4 q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + "Not a valid move: 1, 4\n" 
        + "Game quit! Ending game state:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());
  }

  @Test
  public void testInvalidRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 aaa 1 q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + "Not a valid number: aaa\n" 
        + "Game quit! Ending game state:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());
  }

  @Test
  public void testInvalidCol() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 aaa q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + "Not a valid number: aaa\n" 
        + "Game quit! Ending game state:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());

    m = new TicTacToeModel();
    input = new StringReader("1 1 2 2 1 q");
    output = new StringBuffer();
    c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    stringBuilder = new StringBuilder("   |   |  \n"
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   | O |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + "Game quit! Ending game state:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   | O |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());
  }


  @Test
  public void testValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + "Game quit! Ending game state:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());
  }

  @Test
  public void testOccupied() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 1 q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + "Not a valid move: 1, 1\n" 
        + "Game quit! Ending game state:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());
  }

  @Test
  public void testRunAfterInvalid() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 aa 2 q");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + "Not a valid number: aa\n" 
        + " X | O |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + "Game quit! Ending game state:\n" 
        + " X | O |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  ");
    assertEquals(stringBuilder.toString(), output.toString());
  }

  @Test
  public void testxWin() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 1 1 2 2 2 1 3 2 3");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + " O |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O | O |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X | X | X\n" 
        + "-----------\n" 
        + " O | O |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Game is over! X wins.");
    assertEquals(stringBuilder.toString(), output.toString());
  }


  @Test
  public void testoWin() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 1 1 2 2 2 3 3 2 3");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + " O |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O | O |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O | O |  \n" 
        + "-----------\n" 
        + "   |   | X\n" 
        + "Enter a move for O:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O | O | O\n" 
        + "-----------\n" 
        + "   |   | X\n" 
        + "Game is over! O wins.");
    assertEquals(stringBuilder.toString(), output.toString());
  }
  
  @Test
  public void testTie() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 1 1 2 2 2 3 3 1 3 2 3 3 2 3 1");
    Appendable output = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    StringBuilder stringBuilder = new StringBuilder("   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + " X |   |  \n" 
        + "-----------\n" 
        + " O |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O |   |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for O:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O | O |  \n" 
        + "-----------\n" 
        + "   |   |  \n" 
        + "Enter a move for X:\n" 
        + " X | X |  \n" 
        + "-----------\n" 
        + " O | O |  \n" 
        + "-----------\n" 
        + "   |   | X\n" 
        + "Enter a move for O:\n" 
        + " X | X | O\n" 
        + "-----------\n" 
        + " O | O |  \n" 
        + "-----------\n" 
        + "   |   | X\n" 
        + "Enter a move for X:\n" 
        + " X | X | O\n" 
        + "-----------\n" 
        + " O | O | X\n" 
        + "-----------\n" 
        + "   |   | X\n" 
        + "Enter a move for O:\n" 
        + " X | X | O\n" 
        + "-----------\n" 
        + " O | O | X\n" 
        + "-----------\n" 
        + "   | O | X\n" 
        + "Enter a move for X:\n" 
        + " X | X | O\n" 
        + "-----------\n" 
        + " O | O | X\n" 
        + "-----------\n" 
        + " X | O | X\n" 
        + "Game is over! Tie game.");
    assertEquals(stringBuilder.toString(), output.toString());
  }
}
