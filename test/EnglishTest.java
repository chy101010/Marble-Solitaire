import org.junit.Before;
import org.junit.Test;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the English marble solitaire. Verifying that game state is properly managed, and
 * all game actions are properly validated.
 */
public class EnglishTest {
  private MarbleSolitaireModelImpl defaultGame;
  private MarbleSolitaireModelImpl moveEmptySpotGame;
  private MarbleSolitaireModelImpl armFiveGame;
  private MarbleSolitaireModelImpl armFiveEmptySpotGame;
  private MarbleSolitaireModelImpl armSeventhGame;
  private MarbleSolitaireModelImpl armNineGame;
  private MarbleSolitaireModelImpl armNineEmptySpotGame;

  @Before
  public void testFixture() {
    defaultGame = new MarbleSolitaireModelImpl();
    moveEmptySpotGame = new MarbleSolitaireModelImpl(0, 2);
    armFiveGame = new MarbleSolitaireModelImpl(5);
    armFiveEmptySpotGame = new MarbleSolitaireModelImpl(5, 6, 0);
    armSeventhGame = new MarbleSolitaireModelImpl(7);
    armNineGame = new MarbleSolitaireModelImpl(9);
    armNineEmptySpotGame = new MarbleSolitaireModelImpl(9, 14, 13);
  }


  @Test(expected = IllegalArgumentException.class)
  public void oneThickException() {
    // thickness one
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroThickException() {
    // thickness zero
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeThickException() {
    // thickness negative
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void evenThickException() {
    // thickness even
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void evenThickException1() {
    // thickness even
    MarbleSolitaireModelImpl aGame = new MarbleSolitaireModelImpl(20);
  }


  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException8() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException9() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(10, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException10() {
    MarbleSolitaireModelImpl dGame = new MarbleSolitaireModelImpl(10, 6, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException1() {
    MarbleSolitaireModelImpl aGame = new MarbleSolitaireModelImpl( 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException2() {
    MarbleSolitaireModelImpl zGame = new MarbleSolitaireModelImpl(3, 6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException3() {
    MarbleSolitaireModelImpl eGame = new MarbleSolitaireModelImpl(7, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException4() {
    MarbleSolitaireModelImpl gGame = new MarbleSolitaireModelImpl(7, 18, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException5() {
    MarbleSolitaireModelImpl dGame = new MarbleSolitaireModelImpl(5, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException6() {
    MarbleSolitaireModelImpl dGame = new MarbleSolitaireModelImpl(5, -3, 13);
  }

  @Test(expected = IllegalArgumentException.class)
  public void wrongEmptyGridException7() {
    MarbleSolitaireModelImpl dGame = new MarbleSolitaireModelImpl(5, 103, 13);
  }


  @Test
  public void getGameState() {
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O", defaultGame.getGameState());

    assertEquals("    _ O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O", this.moveEmptySpotGame.getGameState());
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O _ O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "_ O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveEmptySpotGame.getGameState());
    assertEquals("            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O _ O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O" + "\n"
            + "            O O O O O O O", this.armSeventhGame.getGameState());
    assertEquals("                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O _ O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O", this.armNineGame.getGameState());
    assertEquals("                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O _ O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O" + "\n"
            + "                O O O O O O O O O", this.armNineEmptySpotGame.getGameState());
  }

  @Test
  public void testMove() {
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O _ O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    this.armFiveGame.move(6, 4, 6, 6);
    // Left -> Right
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O _ _ O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    this.armFiveGame.move(4, 5, 6, 5);
    // top -> down
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O O O _ O O O O O O O" + "\n"
            + "O O O O O _ O O O O O O O" + "\n"
            + "O O O O _ O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    this.armFiveGame.move(4, 3, 4, 5);
    // left - > right
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "O O O _ _ O O O O O O O O" + "\n"
            + "O O O O O _ O O O O O O O" + "\n"
            + "O O O O _ O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    this.armFiveGame.move(3, 5, 5, 5);
    // top - > down
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O _ O O O" + "\n"
            + "O O O _ _ _ O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O _ O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    this.armFiveGame.move(6, 5, 4, 5);
    // down - > top
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O _ O O O" + "\n"
            + "O O O _ _ O O O O O O O O" + "\n"
            + "O O O O O _ O O O O O O O" + "\n"
            + "O O O O _ _ O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    this.armFiveGame.move(3, 7, 3, 5);
    // right - > left
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O _ _ O" + "\n"
            + "O O O _ _ O O O O O O O O" + "\n"
            + "O O O O O _ O O O O O O O" + "\n"
            + "O O O O _ _ O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
    this.armFiveGame.move(3, 4, 3, 6);
    // top - > down
    assertEquals("        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        _ _ O _ O" + "\n"
            + "O O O _ _ O O O O O O O O" + "\n"
            + "O O O O O _ O O O O O O O" + "\n"
            + "O O O O _ _ O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "O O O O O O O O O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O" + "\n"
            + "        O O O O O", this.armFiveGame.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove() {
    // No the Correct Gap
    this.defaultGame.move(2, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove1() {
    // No Marble in Between
    this.defaultGame.move(1, 3, 3, 3);
    this.defaultGame.move(0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove2() {
    // selected empty first then marble
    this.defaultGame.move(3, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove3() {
    // selected marble and marble
    this.defaultGame.move(2, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove4() {
    // selected out of bound
    this.defaultGame.move(10, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove5() {
    // selected invalid grid instead of empty
    this.defaultGame.move(1, 3, 1, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove6() {
    // selected invalid grid instead of marble
    this.defaultGame.move(0, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove7() {
    // not on the same axis
    this.defaultGame.move(1, 2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove8() {
    this.defaultGame.move(1, 3, 3, 3);
    this.defaultGame.move(2, 5, 2, 3);
    this.defaultGame.move(3, 3, 1, 3);
    // select two empty grids on the same axis and one gap apart
    this.defaultGame.move(2, 5, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove9() {
    // select one marble and one empty with two gaps apart on the same axis
    this.defaultGame.move(0, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove10() {
    // selected marble grid then invalid grid
    this.defaultGame.move(0, 3, 0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove11() {
    // selected negative
    this.defaultGame.move(-1, 3, -1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove12() {
    // selected self
    this.defaultGame.move(2, 1, 2, 1);
  }

  @Test
  public void getScore() {
    // initial board
    assertEquals(32, this.defaultGame.getScore());
    // mutated board
    this.defaultGame.move(1, 3, 3, 3);
    this.defaultGame.move(2, 5, 2, 3);
    assertEquals(30, this.defaultGame.getScore());
    // other larger boards
    assertEquals(104, this.armFiveEmptySpotGame.getScore());
    assertEquals(216, this.armSeventhGame.getScore());
    assertEquals(368, this.armNineEmptySpotGame.getScore());
    assertEquals(368, this.armNineGame.getScore());
  }


  @Test
  public void gameOver1() {
    this.defaultGame.move(1, 3, 3, 3);
    this.defaultGame.move(2, 5, 2, 3);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(3, 3, 1, 3);
    this.defaultGame.move(3, 5, 3, 3);
    this.defaultGame.move(4, 3, 2, 3);
    this.defaultGame.move(5, 4, 3, 4);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(6, 3, 4, 3);
    this.defaultGame.move(4, 2, 4, 4);
    this.defaultGame.move(3, 4, 5, 4);
    this.defaultGame.move(6, 2, 4, 2);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(6, 4, 4, 4);
    this.defaultGame.move(4, 5, 4, 3);
    this.defaultGame.move(2, 2, 2, 4);
    this.defaultGame.move(4, 2, 2, 2);
    this.defaultGame.move(2, 1, 2, 3);
    assertFalse(this.defaultGame.isGameOver());
    assertEquals("    O O O" + "\n"
            + "    O O O" + "\n"
            + "O _ _ O O _ O" + "\n"
            + "O O _ _ _ _ O" + "\n"
            + "O O _ O _ _ O" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _", this.defaultGame.getGameState());
    assertEquals(17, this.defaultGame.getScore());
    this.defaultGame.move(4, 1, 2, 1);
    this.defaultGame.move(2, 0, 2, 2);
    this.defaultGame.move(4, 0, 2, 0);
    this.defaultGame.move(2, 3, 2, 1);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(2, 0, 2, 2);
    this.defaultGame.move(1, 2, 3, 2);
    this.defaultGame.move(0, 3, 2, 3);
    this.defaultGame.move(1, 4, 3, 4);
    assertTrue(this.defaultGame.isGameOver());
    assertEquals("    O _ O" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ O _ _ O" + "\n"
            + "_ _ O _ O _ O" + "\n"
            + "_ _ _ O _ _ O" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _", this.defaultGame.getGameState());
    assertEquals(9, this.defaultGame.getScore());
  }

  @Test
  public void gameOver2() {
    // winning the game
    this.defaultGame.move(3, 5, 3, 3);
    this.defaultGame.move(3, 2, 3, 4);
    this.defaultGame.move(3, 0, 3, 2);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(5, 3, 3, 3);
    this.defaultGame.move(3, 3, 3, 1);
    this.defaultGame.move(5, 2, 3, 2);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(4, 0, 4, 2);
    this.defaultGame.move(2, 1, 4, 1);
    this.defaultGame.move(2, 3, 2, 1);
    this.defaultGame.move(2, 0, 2, 2);
    this.defaultGame.move(2, 5, 2, 3);
    this.defaultGame.move(4, 4, 2, 4);
    this.defaultGame.move(2, 3, 2, 5);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(0, 4, 2, 4);
    this.defaultGame.move(0, 2, 0, 4);
    this.defaultGame.move(4, 6, 4, 4);
    this.defaultGame.move(2, 6, 4, 6);
    this.defaultGame.move(3, 2, 5, 2);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(1, 2, 3, 2);
    this.defaultGame.move(6, 2, 4, 2);
    this.defaultGame.move(3, 2, 5, 2);
    this.defaultGame.move(6, 4, 6, 2);
    this.defaultGame.move(6, 2, 4, 2);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(4, 1, 4, 3);
    this.defaultGame.move(4, 3, 4, 5);
    this.defaultGame.move(4, 6, 4, 4);
    this.defaultGame.move(5, 4, 3, 4);
    this.defaultGame.move(3, 4, 1, 4);
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(0, 4, 2, 4);
    this.defaultGame.move(2, 5, 2, 3);
    this.defaultGame.move(1, 3, 3, 3);
    assertEquals("    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _", this.defaultGame.getGameState());
    assertTrue(this.defaultGame.isGameOver());
  }
}
