import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import tictactoe.*;
import java.io.StringReader;
import java.util.Arrays;
import org.junit.Test;

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

  @Test
  public void testFoo() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("0 0 1 0 0 1 1 1 0 2 1 2");
    Appendable output = System.out;
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(m.isGameOver());
    assertTrue(m.getWinner() == Player.X);
  }
}


// 2 2
// 2 2 2
// 1 hh
// hh 1
// hh hh
// hhhh
// ' '
// '
// 1
//  1
// 1    1
// 1 .. 1
// 1 q
// q 1
// q