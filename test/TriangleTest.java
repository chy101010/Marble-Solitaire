import org.junit.Before;
import org.junit.Test;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for the Triangle marble solitaire Model. Verifying that game state is properly
 * managed, and all game actions are properly validated.
 */
public class TriangleTest {
  // Constructor Tests
  // Single Argument With One Parameter - Non-positive
  // Two Argument with the positions invalid
  // Three Argument With Positive length but invalid positions
  // Three Argument With negative length but valid positions

  // Valid Move Test
  // Six valid directions

  // Invalid Move Test
  // from position doesn't exist/ out of bound / invalid grid
  // to position doesn't exist/ out of bound / invalid grid
  // not on the correct axis
  // position from does not have a marble
  // position to does not have an empty
  // jumping over empty
  // positions are incorrect positions apart
  // jumping over itself
  // position from isn't marble/ position to isn't empty
  private MarbleSolitaireModel defaultGame;
  private MarbleSolitaireModel oneLength;
  private MarbleSolitaireModel twoLength;
  private MarbleSolitaireModel sixLength;
  private MarbleSolitaireModel sevenLength;
  private MarbleSolitaireModel tenLength;

  @Before
  public void testFixture() {
    this.defaultGame = new TriangleSolitaireModelImpl();
    this.oneLength = new TriangleSolitaireModelImpl(1);
    this.twoLength = new TriangleSolitaireModelImpl(2, 1, 0);
    this.sixLength = new TriangleSolitaireModelImpl(6, 4, 2);
    this.sevenLength = new TriangleSolitaireModelImpl(7, 4, 2);
    this.tenLength = new TriangleSolitaireModelImpl(10, 3, 3);
  }

  @Test
  public void getGameState() {
    this.oneLength = new TriangleSolitaireModelImpl(1);
    this.twoLength = new TriangleSolitaireModelImpl(2, 1, 0);
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", this.defaultGame.getGameState());
    assertEquals(" O\n"
            + "_ O", this.twoLength.getGameState());
    assertEquals("_", oneLength.getGameState());
    assertEquals("     O\n"
            + "    O O\n"
            + "   O O O\n"
            + "  O O O O\n"
            + " O O _ O O\n"
            + "O O O O O O", this.sixLength.getGameState());
    assertEquals("         O\n"
            + "        O O\n"
            + "       O O O\n"
            + "      O O O _\n"
            + "     O O O O O\n"
            + "    O O O O O O\n"
            + "   O O O O O O O\n"
            + "  O O O O O O O O\n"
            + " O O O O O O O O O\n"
            + "O O O O O O O O O O", this.tenLength.getGameState());
  }


  @Test(expected = IllegalArgumentException.class)
  public void illegalOneArgConstructor() {
    // Non-positive length
    new TriangleSolitaireModelImpl(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalOneArgConstructor1() {
    // Non-positive length
    new TriangleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor() {
    // Two Argument with the positions invalid
    new TriangleSolitaireModelImpl(0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor1() {
    // Two Argument with the positions invalid
    new TriangleSolitaireModelImpl(4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalTwoArgConstructor2() {
    // Two Argument with the positions invalid
    new TriangleSolitaireModelImpl(1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor() {
    // Three Argument With Positive length but invalid positions
    new TriangleSolitaireModelImpl(1, 1, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor1() {
    // Three Argument With Positive length but invalid positions
    new TriangleSolitaireModelImpl(1, 0, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor2() {
    // Three Argument With Positive length but invalid positions
    new TriangleSolitaireModelImpl(2, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor3() {
    // Three Argument With Positive length but invalid positions
    new TriangleSolitaireModelImpl(4, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor4() {
    // Three Argument With negative length but valid positions
    new TriangleSolitaireModelImpl(-1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor5() {
    // Three Argument With negative length but valid positions
    new TriangleSolitaireModelImpl(0, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor6() {
    // Three Argument With negative length but valid positions
    new TriangleSolitaireModelImpl(-10, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalThreeArgConstructor7() {
    // Three Argument With negative length and invalid positions
    new TriangleSolitaireModelImpl(-10, 1, 2);
  }

  @Test
  public void getScore() {
    assertEquals(2, this.twoLength.getScore());
    assertEquals(0, this.oneLength.getScore());
    assertEquals(20, this.sixLength.getScore());
    assertTrue(this.twoLength.isGameOver());
    assertEquals(14, this.defaultGame.getScore());
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", this.defaultGame.getGameState());
    this.defaultGame.move(2, 0, 0, 0);
    assertEquals("    O\n"
            + "   _ O\n"
            + "  _ O O\n"
            + " O O O O\n"
            + "O O O O O", this.defaultGame.getGameState());
    assertEquals(13, this.defaultGame.getScore());
    this.defaultGame.move(4, 0, 2, 0);
    assertEquals("    O\n"
            + "   _ O\n"
            + "  O O O\n"
            + " _ O O O\n"
            + "_ O O O O", this.defaultGame.getGameState());
  }

  @Test
  public void endGame() {
    assertEquals("    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O", this.defaultGame.getGameState());
    assertEquals(14, this.defaultGame.getScore());
    this.defaultGame.move(2, 0, 0, 0);
    assertEquals(13, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  _ O O\n"
            + " O O O O\n"
            + "O O O O O", this.defaultGame.getGameState());
    this.defaultGame.move(2, 2, 2, 0);
    assertEquals(12, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  O _ _\n"
            + " O O O O\n"
            + "O O O O O", this.defaultGame.getGameState());
    this.defaultGame.move(4, 4, 2, 2);
    assertEquals(11, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    assertFalse(this.defaultGame.isGameOver());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  O _ O\n"
            + " O O O _\n"
            + "O O O O _", this.defaultGame.getGameState());
    this.defaultGame.move(4, 2, 4, 4);
    assertFalse(this.defaultGame.isGameOver());
    assertEquals(10, this.defaultGame.getScore());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  O _ O\n"
            + " O O O _\n"
            + "O O _ _ O", this.defaultGame.getGameState());
    this.defaultGame.move(3, 1, 3, 3);
    assertFalse(this.defaultGame.isGameOver());
    assertEquals(9, this.defaultGame.getScore());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  O _ O\n"
            + " O _ _ O\n"
            + "O O _ _ O", this.defaultGame.getGameState());
    this.defaultGame.move(4, 0, 4, 2);
    assertFalse(this.defaultGame.isGameOver());
    assertEquals(8, this.defaultGame.getScore());
    assertFalse(this.defaultGame.isGameOver());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  O _ O\n"
            + " O _ _ O\n"
            + "_ _ O _ O", this.defaultGame.getGameState());
    this.defaultGame.move(2, 0, 4, 0);
    assertEquals(7, this.defaultGame.getScore());
    assertEquals("    O\n"
            + "   _ O\n"
            + "  _ _ O\n"
            + " _ _ _ O\n"
            + "O _ O _ O", this.defaultGame.getGameState());
    assertTrue(this.defaultGame.isGameOver());
  }

  @Test
  public void testMove() {
    // moving from top-left
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 0, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    _ O O\n"
            + "   O _ O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
  }

  @Test
  public void testMove1() {
    // moving from top-right
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O _\n"
            + "   O O _ O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
  }

  @Test
  public void testMove2() {
    // moving from left
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 0, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  _ _ O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
  }

  @Test
  public void testMove3() {
    // moving from right
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 4, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O _ _\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
  }

  @Test
  public void testMove4() {
    // moving from bottom-left
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O _ O O O\n"
            + "O O _ O O O O", this.sevenLength.getGameState());
  }

  @Test
  public void testMove5() {
    // moving from bottom-right
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 4, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O O _ O O\n"
            + "O O O O _ O O", this.sevenLength.getGameState());
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMove() {
    // from position doesn't exist/ out of bound
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 0, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    _ O O\n"
            + "   O _ O O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(3, -1, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove1() {
    // to position doesn't exist/ out of bound
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 1, 4, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove2() {
    // from position doesn't exist/ invalid
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O _\n"
            + "   O O _ O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(3, 4, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove3() {
    // to position doesn't exist/ invalid
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O _\n"
            + "   O O _ O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 1, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove4() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 1, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove5() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 5, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove6() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(3, 1, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove7() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(3, 2, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove77() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(5, 1, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove7777() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(5, 3, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove77777() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(5, 4, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove8() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(3, 0, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove9() {
    // not on the correct axis
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(5, 2, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove10() {
    // position from does not have a marble
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 0, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  _ _ O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 3, 4, 1);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  _ O O O O\n"
            + " O O _ O O O\n"
            + "O O O _ O O O", this.sevenLength.getGameState());
    this.sevenLength.move(3, 2, 5, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O _ O\n"
            + "  _ O _ O O\n"
            + " O O O O O O\n"
            + "O O O _ O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 0, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove11() {
    // position to does not have an empty
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(5, 2, 5, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove12() {
    // jumping over empty
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O _\n"
            + "   O O _ O\n"
            + "  O O O O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 2, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove13() {
    // positions are incorrect positions apart
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O _ O O O\n"
            + "O O _ O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 5, 6, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove14() {
    // positions are incorrect positions apart
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O _ O O O\n"
            + "O O _ O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 6, 6, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove15() {
    // positions are incorrect positions apart
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(6, 2, 4, 2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O O O\n"
            + " O O _ O O O\n"
            + "O O _ O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(2, 2, 5, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove16() {
    // jumping over itself
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 2, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove17() {
    // jumping over itself
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 3, 4, 3);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMove18() {
    // position from isn't marble/ position to isn't empty
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 2, 4, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void invalidMove19() {
    // position from isn't marble/ position to isn't empty
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 2, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidMove20() {
    // position from isn't marble/ position to isn't empty
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O _ O O\n"
            + " O O O O O O\n"
            + "O O O O O O O", this.sevenLength.getGameState());
    this.sevenLength.move(4, 2, 6, 2);
  }
}
