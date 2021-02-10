import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.Arrays;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.ConfirmInputsMove;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the marble solitaire controller. Verifying that outputs correspond to inputs, and
 * the controller conveys the correct inputs to the model.
 */
public class ControllerTest {

  private MarbleSolitaireModelImpl m;
  MarbleSolitaireModelImpl b;
  private StringBuilder gameLog;

  @Before
  public void testFixture() {
    m = new MarbleSolitaireModelImpl();
    b = new MarbleSolitaireModelImpl(0, 3);
    gameLog = new StringBuilder();
  }

  // Testing Inputs
  // "q" or "Q" in before a complete inputs 4 q 4 4/ q 4 4 4/ 4 4 q 4/ 4 4 4 q   # Done
  // Invalid inputs between valid inputs  # Done
  // Valid inputs, but invalid for move(out of bound/incorrect gap/not marble and empty) # Done
  // Only Invalid inputs # Done
  // Appenable exception # Done
  // Game Over and score # Done
  // Correct messages # Done
  // No Readable Inputs # Done
  // Null marble - playGo(Marble) # Done
  // Null readable and appendable - constructor # Done
  // Controller correctly passing input to model? # Done
  // A list of correct inputs # Done
  // Testing invalid then move or quit # Done
  // Invalid move and valid move together # Done
  // Just invalid move # Done
  // Incorrect q command # Done
  // Other models
  @Test
  public void testSingleValidMove() {
    StringBuilder gameLog = new StringBuilder();
    StringReader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void testAbsurdGameQuite() {
    String expected = "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32";
    StringBuilder gameLog1 = new StringBuilder();
    StringBuilder gameLog2 = new StringBuilder();
    StringBuilder gameLog3 = new StringBuilder();
    StringReader in = new StringReader("q 4 2 4 4");
    StringReader in1 = new StringReader("4 q 2 4 4");
    StringReader in2 = new StringReader("4 2 q 4 4");
    StringReader in3 = new StringReader("4 2 4 q 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    MarbleSolitaireController c1 = new MarbleSolitaireControllerImpl(in1, gameLog1);
    c1.playGame(m);
    MarbleSolitaireController c2 = new MarbleSolitaireControllerImpl(in2, gameLog2);
    c2.playGame(m);
    MarbleSolitaireController c3 = new MarbleSolitaireControllerImpl(in3, gameLog3);
    c3.playGame(m);
    assertEquals(expected, gameLog.toString());
    assertEquals(expected, gameLog1.toString());
    assertEquals(expected, gameLog2.toString());
    assertEquals(expected, gameLog3.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testIncorrectQuit() {
    StringReader in = new StringReader("2q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
  }

  @Test(expected = IllegalStateException.class)
  public void testIncorrectQuit1() {
    StringReader in = new StringReader("2q qqq qq qqq quit 1q wq");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
  }

  @Test
  public void testInvalidInputsBetweenValidInputs() {
    StringReader in = new StringReader("2 !@# !@#!@ 4 4 4 3 WE 2 3 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Please enter an valid input!" + "\n"
            + "Please enter an valid input!" + "\n"
            + "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Please enter an valid input!" + "\n"
            + "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 30" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 30", gameLog.toString());
  }

  @Test
  public void invalidMove() {
    // select Invalid grid instead of Marble grid 1 2 1 4
    // (1,2) (1,4) - "An Invalid Grid is selected"
    // select Invalid grid instead of Empty grid 1 4 1 2
    // (1,4) (1,2) - "An Invalid Grid is selected"
    // select out of bound 0 0 0 2
    // (0,0) (0,2) - "At least one of the positions is either out of the board or points..."
    // select out of bound 10 0 12 0
    // (10,0) (12,0) - "At least one of the positions is either out of the board or points..."
    // select Marble and Empty but the gap is incorrect 4 4 1 4
    // (4,4) (1,4) - "The gap between these two positions is incorrect amount"
    // select Marble and Empty but there are not in the same axis 3 3 1 4
    // (2,3) (1,4) - "The positions are not on the same axis"
    // select Empty then Marble 1 4 3 4
    // (1,4) (3,4) - "Must first select a Marble then an Empty grid"
    // select Marble then Empty but the grid in between is empty 3 4 1 4 1 4 3 4
    // (3,4) (1,4)
    // (1,4) (3,4) - "The grid in between isn't a Marble"
    StringReader in = new StringReader("1 2 1 4 1 4 1 2 0 0 0 2 10 0 12 0 "
            + "4 4 1 4 2 3 1 4 1 4 3 4 3 4 1 4 1 4 3 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(b);
    assertEquals("    O _ O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. An Invalid Grid is selected" + "\n"
            + "Invalid move. Play again. An Invalid Grid is selected" + "\n"
            + "Invalid move. Play again. At least one of the positions is out of the board"
            + "\n"
            + "Invalid move. Play again. At least one of the positions is out of the board"
            + "\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount"
            + "\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount"
            + "\n"
            + "Invalid move. Play again. Must first select a Marble then an Empty grid" + "\n"
            + "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Invalid move. Play again. The grid in between isn't a Marble" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void invalidAndValidMove() {
    // (1,2) (1,4) - "An Invalid Grid is selected"
    StringReader in = new StringReader("1 2 1 4 2 4 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. An Invalid Grid is selected" + "\n"
            + "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void invalidAndValidMove1() {
    // (1,4) (1,2) - "An Invalid Grid is selected"
    StringReader in = new StringReader("1 4 1 2 4 2 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. An Invalid Grid is selected" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void invalidAndValidMove2() {
    // (0,0) (0,2) (10,0) (12,0)  - "At least one of the positions is either..."
    StringReader in = new StringReader("0 0 0 2 10 0 12 0 4 6 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. At least one of the positions is "
            + "out of the board" + "\n"
            + "Invalid move. Play again. At least one of the positions is "
            + "out of the board" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O _ _ O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O _ _ O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void invalidAndValidMove3() {
    // (4,4) (1,4) - "The gap between these two positions is incorrect amount"
    // (2,3) (1,4) - "The positions are not on the same axis"
    StringReader in = new StringReader("4 4 1 4 2 3 1 4 6 4 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount"
            + "\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount"
            + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "    O _ O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "    O _ O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void invalidAndValidMove4() {
    // (1,4) (3,4) - "Must first select a Marble then an Empty grid"
    StringReader in = new StringReader("1 4 3 4 6 4 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. Must first select a Marble then an Empty grid" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "    O _ O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "    O _ O" + "\n"
            + "    O O O" + "\n"
            + "Score: 31", gameLog.toString());
  }

  @Test
  public void justInvalidMove() {
    // (1,4) (3,4) - "Must first select a Marble then an Empty grid"
    StringReader in = new StringReader("1 4 3 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. Must first select a Marble then an Empty grid" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32", gameLog.toString());
  }

  @Test
  public void justInvalidMove2() {
    // (2,3) (1,4) - "The positions are not on the same axis"
    StringReader in = new StringReader("2 3 1 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount"
            + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32", gameLog.toString());
  }

  @Test
  public void justInvalidMove3() {
    // (4,4) (1,4) - "The gap between these two positions is incorrect amount"
    StringReader in = new StringReader("4 4 1 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount"
            + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32", gameLog.toString());
  }


  @Test
  public void justInvalidMove4() {
    // (0,0) (0,2) (10,0) (12,0)  - "At least one of the positions is either..."
    StringReader in = new StringReader("0 0 0 2 10 0 12 0 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. At least one of the positions is "
            + "out of the board" + "\n"
            + "Invalid move. Play again. At least one of the positions is "
            + "out of the board" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32", gameLog.toString());
  }

  @Test
  public void justInvalidMove5() {
    // (1,4) (1,2) - "An Invalid Grid is selected"
    StringReader in = new StringReader("1 4 1 2 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Invalid move. Play again. An Invalid Grid is selected" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32", gameLog.toString());
  }

  @Test
  public void onlyInvalidInputs() {
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(
            new StringReader("QI IH IO@HI q"), gameLog);
    c.playGame(b);
    assertEquals("    O _ O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Please enter an valid input!" + "\n"
            + "Please enter an valid input!" + "\n"
            + "Please enter an valid input!" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O _ O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32", gameLog.toString());
  }


  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    Appendable gameLog = new FailingAppendable();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(
            new StringReader("4 2 4 4 q"), gameLog);
    c.playGame(m);
  }

  @Test
  public void gameOver() {
    StringReader over = new StringReader("2 4 4 4 3 6 3 4 4 4 2 4 4 6 4 4 5 4 3 4 6 5 4 5 7 4"
            + " 5 4 5 3 5 5 4 5 6 5 7 3 5 3 7 5 5 5 5 6 5 4 3 3 3 5 5 3 3 3 3 2 3 4 5 2 3 2 3 1 3 3"
            + " 5 1 3 1 3 4 3 2 3 1 3 3 2 3 4 3 1 4 3 4 2 5 4 5");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(over, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 9, lines.length));
    assertEquals("Game over!\n"
            + "    O _ O\n"
            + "    _ _ _\n"
            + "_ _ _ O _ _ O\n"
            + "_ _ O _ O _ O\n"
            + "_ _ _ O _ _ O\n"
            + "    _ _ _\n"
            + "    _ _ _\n"
            + "Score: 9", lastMsg);
  }

  @Test(expected = IllegalStateException.class)
  public void testEmptyReadable() {
    StringReader in = new StringReader("");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
  }

  @Test(expected = IllegalStateException.class)
  public void testIncompleteReadable() {
    StringReader in = new StringReader("4 2 4 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
  }

  @Test(expected = IllegalStateException.class)
  public void testIncompleteReadable1() {
    StringReader in = new StringReader("4 2");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyMarble() {
    StringReader in = new StringReader("4 2 4 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyReadable() {
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(null, gameLog);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAppendable() {
    StringReader in = new StringReader("");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAppendableReadable() {
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(null, null);
  }

  @Test
  public void comfirmInputs() {
    StringBuilder log = new StringBuilder();
    ConfirmInputsMove m = new ConfirmInputsMove(log);
    StringReader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void comfirmInputs1() {
    StringBuilder log = new StringBuilder();
    ConfirmInputsMove m = new ConfirmInputsMove(log);
    StringReader in = new StringReader("4 W 2 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void comfirmInputs2() {
    StringBuilder log = new StringBuilder();
    ConfirmInputsMove m = new ConfirmInputsMove(log);
    StringReader in = new StringReader("4 2 4 4 4 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void comfirmInputs3() {
    StringBuilder log = new StringBuilder();
    ConfirmInputsMove m = new ConfirmInputsMove(log);
    StringReader in = new StringReader("4 2 4 4 LOL LOL 4 2 4 3 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("fromRow = 3, fromCol = 1, toRow = 3, toCol = 3\n"
            + "fromRow = 3, fromCol = 1, toRow = 3, toCol = 2\n", log.toString());
  }

  @Test
  public void comfirmInputs4() {
    StringBuilder log = new StringBuilder();
    ConfirmInputsMove m = new ConfirmInputsMove(log);
    StringReader in = new StringReader("4 2 q 4 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("", log.toString());
  }

  @Test
  public void winGame() {
    StringReader in = new StringReader(" 4 6 4 4 4 3 4 5 4 1 4 3 6 4 4 4 4 4 4 2 6 3 4 3 "
            + "5 1 5 3 3 2 5 2 3 4 3 2 3 1 3 3 3 6 3 4 5 5 3 5 3 4 3 6 1 5 3 5 1 3 1 5 5 7 5 "
            + "5 3 7 5 7 4 3 6 3 2 3 4 3 7 3 5 3 4 3 6 3 7 5 7 3 7 3 5 3 5 2 5 4 5 4 5 6 5 7 "
            + "5 5 6 5 4 5 4 5 2 5 1 5 3 5 3 6 3 4 2 4 4 4");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    String lastMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 9, lines.length));
    String upDownMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 25, lines.length - 9));
    String downUpMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 49, lines.length - 33));
    String righLeftMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 33, lines.length - 17));
    String leftRightMsg = String.join("\n",
            Arrays.copyOfRange(lines, lines.length - 73, lines.length - 57));
    assertEquals("Game over!\n"
            + "    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _\n"
            + "Score: 1", lastMsg);
    assertEquals(
            "    _ _ _\n"
                    + "    _ O _\n"
                    + "_ _ _ O _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "    _ _ _\n"
                    + "    _ _ _\n"
                    + "Score: 2" + "\n"
                    + "    _ _ _\n"
                    + "    _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "_ _ _ O _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "    _ _ _\n"
                    + "    _ _ _\n"
                    + "Score: 1", upDownMsg);
    assertEquals(
            "    _ _ O\n"
                    + "    _ O _\n"
                    + "_ _ _ _ O O _\n"
                    + "_ _ _ _ O _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "    _ _ _\n"
                    + "    _ _ _\n"
                    + "Score: 5" + "\n"
                    + "    _ _ O\n"
                    + "    _ O O\n"
                    + "_ _ _ _ _ O _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "    _ _ _\n"
                    + "    _ _ _\n"
                    + "Score: 4", downUpMsg);
    assertEquals(
            "    _ _ _\n"
                    + "    _ O _\n"
                    + "_ _ _ _ O O _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "    _ _ _\n"
                    + "    _ _ _\n"
                    + "Score: 3" + "\n"
                    + "    _ _ _\n"
                    + "    _ O _\n"
                    + "_ _ _ O _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "    _ _ _\n"
                    + "    _ _ _\n"
                    + "Score: 2", righLeftMsg);
    assertEquals(
            "    _ _ O\n"
                    + "    _ O _\n"
                    + "_ _ _ _ O O _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "_ _ _ O O _ O\n"
                    + "    _ _ O\n"
                    + "    _ _ _\n"
                    + "Score: 8" + "\n"
                    + "    _ _ O\n"
                    + "    _ O _\n"
                    + "_ _ _ _ O O _\n"
                    + "_ _ _ _ _ _ _\n"
                    + "_ _ _ _ _ O O\n"
                    + "    _ _ O\n"
                    + "    _ _ _\n"
                    + "Score: 7", leftRightMsg);
  }

  @Test
  public void gameWithFiveArmThick() {
    // (4,7) (6,7) top - > down
    // (7,7) (5,7) down - > top
    // (6, 5) (6,7) left - > right
    // (4,9) (4,7) right -> left
    // (4,7) (4,9) -> Empty grid in between
    // (3,7) (4,8) -> not on the same axis
    // (6 5) (6 3) -> Empty is selected first
    // (-10 5) (6 3) -> Out of bound
    // (4,11) (4, 9) -> Invalid to empty
    // (6,2) (6,5) -> wrong distance
    MarbleSolitaireModelImpl f = new MarbleSolitaireModelImpl(5, 5, 6);
    StringReader in = new StringReader("4 7 6 7 7 7 5 7 6 5 6 7 4 9 4 7 4 7 4 9 3 7 4 8 "
            + "6 5 6 3 -10 5 6 3 4 11 4 9 6 2 6 5 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(f);
    assertEquals("        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 104\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O _ O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 103\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O _ O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 102\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O _ O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 101\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O _ _\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 100\n"
            + "Invalid move. Play again. The grid in between isn't a Marble\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount\n"
            + "Invalid move. Play again. Must first select a Marble then an Empty grid\n"
            + "Invalid move. Play again. At least one of the positions is out of the board\n"
            + "Invalid move. Play again. An Invalid Grid is selected\n"
            + "Invalid move. Play again. The gap between these two positions is incorrect amount\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O _ _\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O _ _ O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "Score: 100", gameLog.toString());
  }

  @Test
  public void testQuitMove() {
    StringBuilder gameLog = new StringBuilder();
    StringReader in = new StringReader("q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(in, gameLog);
    c.playGame(m);
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32" + "\n"
            + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O" + "\n"
            + "Score: 32", gameLog.toString());
  }
}
