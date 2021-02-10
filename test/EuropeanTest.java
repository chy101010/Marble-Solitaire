import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the European marble solitaire Model. Verifying that game state is properly
 * managed, and all game actions are properly validated.
 */
public class EuropeanTest {
  private MarbleSolitaireModel defaultGame;
  private MarbleSolitaireModel fiveThick;
  private MarbleSolitaireModel fiveEmptyThick;
  private MarbleSolitaireModel threeEmptyThick;

  @Before
  public void testFixture() {
    this.defaultGame = new EuropeanSolitaireModelImpl();
    this.fiveThick = new EuropeanSolitaireModelImpl(5);
    this.threeEmptyThick = new EuropeanSolitaireModelImpl(1, 1);
    this.fiveEmptyThick = new EuropeanSolitaireModelImpl(5, 1, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalOneArgConstructor() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalOneArgConstructor1() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalOneArgConstructor2() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalOneArgConstructor3() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor1() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor2() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(10, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor3() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor4() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(5, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(5, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor1() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(6, 6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor2() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(5, -3, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor3() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(5, 2, 11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor4() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(6, 20, 6);
  }


  @Test
  public void getGameState() {
    MarbleSolitaireModel a = new EuropeanSolitaireModelImpl(3, 2);
    MarbleSolitaireModel b = new EuropeanSolitaireModelImpl(1, 1);
    MarbleSolitaireModel c = new EuropeanSolitaireModelImpl(7, 14, 16);
    MarbleSolitaireModel sevenThick = new EuropeanSolitaireModelImpl(7);
    assertEquals(
            "    O O O" + "\n"
                    + "  O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "  O O O O O" + "\n"
                    + "    O O O", defaultGame.getGameState());
    assertEquals(
            "    O O O" + "\n"
                    + "  _ O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "  O O O O O" + "\n"
                    + "    O O O", threeEmptyThick.getGameState());
    assertEquals(
            "    O O O" + "\n"
                    + "  O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O _ O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "  O O O O O" + "\n"
                    + "    O O O", a.getGameState());
    assertEquals(
            "    O O O" + "\n"
                    + "  _ O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "  O O O O O" + "\n"
                    + "    O O O", b.getGameState());

    assertEquals(
            "        O O O O O" + "\n"
                    + "      O O O O O O O" + "\n"
                    + "    O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O _ O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O" + "\n"
                    + "    O O O O O O O O O" + "\n"
                    + "      O O O O O O O" + "\n"
                    + "        O O O O O", this.fiveThick.getGameState());
    assertEquals(
            "        O O O O O" + "\n"
                    + "      O O O O O O _" + "\n"
                    + "    O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O" + "\n"
                    + "    O O O O O O O O O" + "\n"
                    + "      O O O O O O O" + "\n"
                    + "        O O O O O", this.fiveEmptyThick.getGameState());
    assertEquals(
            "            O O O O O O O" + "\n"
                    + "          O O O O O O O O O" + "\n"
                    + "        O O O O O O O O O O O" + "\n"
                    + "      O O O O O O O O O O O O O" + "\n"
                    + "    O O O O O O O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O _ O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O O O O O O O" + "\n"
                    + "    O O O O O O O O O O O O O O O" + "\n"
                    + "      O O O O O O O O O O O O O" + "\n"
                    + "        O O O O O O O O O O O" + "\n"
                    + "          O O O O O O O O O" + "\n"
                    + "            O O O O O O O", sevenThick.getGameState());
    assertEquals(
            "            O O O O O O O" + "\n"
                    + "          O O O O O O O O O" + "\n"
                    + "        O O O O O O O O O O O" + "\n"
                    + "      O O O O O O O O O O O O O" + "\n"
                    + "    O O O O O O O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O O O O O O O" + "\n"
                    + "  O O O O O O O O O O O O O O O O O" + "\n"
                    + "    O O O O O O O O O O O O O O _" + "\n"
                    + "      O O O O O O O O O O O O O" + "\n"
                    + "        O O O O O O O O O O O" + "\n"
                    + "          O O O O O O O O O" + "\n"
                    + "            O O O O O O O", c.getGameState());
  }


  @Test
  public void validMove() {
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    // Up -> Down
    this.defaultGame.move(1, 3, 3, 3);
    assertEquals("    O O O" + "\n"
            + "  O O _ O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    // Down -> UP
    this.defaultGame.move(4, 3, 2, 3);
    assertEquals("    O O O" + "\n"
            + "  O O _ O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    // Right -> Left
    this.defaultGame.move(1, 5, 1, 3);
    assertEquals("    O O O" + "\n"
            + "  O O O _ _" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    // Left -> Right
    this.defaultGame.move(1, 2, 1, 4);
    assertEquals("    O O O" + "\n"
            + "  O _ _ O _" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove() {
    // Not on the correct axis
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(2, 2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove1() {
    // Not on the correct axis
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(1, 4, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove111() {
    // Not on the correct axis
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(1, 2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove2() {
    // Not on the correct axis
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(2, 2, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove22() {
    // Not on the correct axis
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(2, 4, 3, 3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMove3() {
    // position from doesn not exist / outOfBound
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(-1, 4, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove4() {
    // position to doesn not exist / outOfBound
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 6, 3, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove5() {
    // position from does not have a marble
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 3, 3);
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 4, 3, 2);
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ O _ _ O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove6() {
    // position to does not have an empty
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove7() {
    // jumping over empty
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 3, 3);
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove8() {
    // positions are two positions apart
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 0, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove88() {
    // positions are three positions apart
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 3, 3);
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 2, 3, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove9() {
    // positions from is invalid
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 3, 3);
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(1, 0, 3, 1);
    assertEquals("    O O O" + "\n"
            + "  _ O O O O" + "\n"
            + "O _ O O O O O" + "\n"
            + "O O _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(1, 3, 1, 1);
    assertEquals("    O O O" + "\n"
            + "  O _ _ O O" + "\n"
            + "O _ O O O O O" + "\n"
            + "O O _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(1, 0, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove10() {
    // positions to is invalid
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 3, 3);
    assertEquals("    O O O" + "\n"
            + "  O O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(1, 0, 3, 1);
    assertEquals("    O O O" + "\n"
            + "  _ O O O O" + "\n"
            + "O _ O O O O O" + "\n"
            + "O O _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "  O O O O O" + "\n"
            + "    O O O", this.defaultGame.getGameState());
    this.defaultGame.move(1, 2, 1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove11() {
    // from and to don't exist / outOfBound
    this.defaultGame.move(-1, -2, 20, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove12() {
    // jumping over itself
    this.defaultGame.move(3, 2, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove13() {
    // position from isn't marble/ position to isn't empty
    this.defaultGame.move(3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove14() {
    // jumping over itself
    this.defaultGame.move(3, 3, 3, 3);
  }

  @Test
  public void gameOver() {
    assertEquals(36, this.defaultGame.getScore());
    this.defaultGame.move(3, 5, 3, 3);
    this.defaultGame.move(3, 2, 3, 4);
    this.defaultGame.move(3, 0, 3, 2);
    assertEquals(33, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(5, 3, 3, 3);
    this.defaultGame.move(3, 3, 3, 1);
    this.defaultGame.move(5, 2, 3, 2);
    assertEquals(30, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(4, 0, 4, 2);
    this.defaultGame.move(2, 1, 4, 1);
    this.defaultGame.move(2, 3, 2, 1);
    this.defaultGame.move(2, 0, 2, 2);
    this.defaultGame.move(2, 5, 2, 3);
    this.defaultGame.move(4, 4, 2, 4);
    this.defaultGame.move(2, 3, 2, 5);
    assertEquals(23, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(0, 4, 2, 4);
    this.defaultGame.move(0, 2, 0, 4);
    this.defaultGame.move(4, 6, 4, 4);
    this.defaultGame.move(2, 6, 4, 6);
    this.defaultGame.move(3, 2, 5, 2);
    assertEquals(18, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(1, 2, 3, 2);
    this.defaultGame.move(6, 2, 4, 2);
    this.defaultGame.move(3, 2, 5, 2);
    this.defaultGame.move(6, 4, 6, 2);
    this.defaultGame.move(6, 2, 4, 2);
    assertEquals(13, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(4, 1, 4, 3);
    this.defaultGame.move(4, 3, 4, 5);
    this.defaultGame.move(4, 6, 4, 4);
    this.defaultGame.move(5, 4, 3, 4);
    this.defaultGame.move(3, 4, 1, 4);
    assertEquals(8, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    this.defaultGame.move(0, 4, 2, 4);
    this.defaultGame.move(2, 5, 2, 3);
    this.defaultGame.move(1, 3, 3, 3);
    assertEquals("    _ _ _\n"
            + "  O _ _ _ O\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "  O _ _ _ O\n"
            + "    _ _ _", this.defaultGame.getGameState());
    assertTrue(this.defaultGame.isGameOver());
    assertEquals(5, this.defaultGame.getScore());
  }

  @Test
  public void getScore() {
    assertEquals(128, this.fiveEmptyThick.getScore());
    assertEquals(128, this.fiveThick.getScore());
    assertEquals(36, this.defaultGame.getScore());
    assertEquals(36, this.threeEmptyThick.getScore());
    this.defaultGame.move(3, 5, 3, 3);
    assertEquals(35, this.defaultGame.getScore());
    this.defaultGame.move(3, 2, 3, 4);
    assertEquals(34, this.defaultGame.getScore());
    this.defaultGame.move(3, 0, 3, 2);
    assertEquals(33, this.defaultGame.getScore());
  }
}
