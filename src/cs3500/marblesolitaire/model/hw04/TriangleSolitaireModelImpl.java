package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

import cs3500.marblesolitaire.model.hw02.Grid;

/**
 * Represents Triangle marble solitaire model, supported methods that allow user to make a
 * orthogonal and diagonal valid move, get the string representation of the board, check whether the
 * game is over, and get the score. This is a sub-class of {@code MarbleAbstract} with its own
 * getGameState methods, unique positions for {@code Grid.Invalid} and {@code Grid.Marble}, and,
 * additionally, supported diagonal moves.
 */
public class TriangleSolitaireModelImpl extends MarbleAbstract {

  /**
   * Constructs a Triangle Marble GameBoard with the given length and an initial empty spot at
   * (r,c).
   *
   * @param length the length of the game board
   * @param r      the row position to place the empty spot
   * @param c      the column position to place the empty spot
   * @throws IllegalArgumentException if the given (r,c) position is an invalid empty spot or if the
   *                                  given {@code length} is less than 1.
   */
  public TriangleSolitaireModelImpl(int length, int r, int c) {
    super(length, r, c);
  }

  /**
   * Constructs a Triangle Marble GameBoard with a length of 5 with an initial empty spot at given
   * (r,c).
   *
   * @param r the row position to place the empty spot
   * @param c the column position to place the empty spot
   * @throws IllegalArgumentException if the given (r,c) position is an invalid empty spot.
   */
  public TriangleSolitaireModelImpl(int r, int c) {
    this(5, r, c);
  }


  /**
   * Constructs a Triangle Marble GameBoard with the given length with an initial empty spot at
   * (0,0).
   *
   * @param length the length of the game board
   * @throws IllegalArgumentException if the given (r,c) position is an invalid empty spot or if the
   *                                  given {@code length} is less than 1.
   */
  public TriangleSolitaireModelImpl(int length) {
    this(length, 0, 0);
  }


  /**
   * Constructs a Triangle Marble GameBoard with a length of 5 and an initial empty spot at (0,0).
   */
  public TriangleSolitaireModelImpl() {
    this(5, 0, 0);
  }

  /**
   * Return a string representation of the game board. Each row of marbles is centered with respect
   * to the dimension of the board.
   *
   * @return a string representation of the board.
   */
  @Override
  public String getGameState() {
    List<String> rows = new ArrayList<>();
    for (int r = 0; r < this.board.length; r++) {
      List<String> rowStrings = new ArrayList<>();
      int space = this.board.length - 2 - r;
      for (; space >= 0; space--) {
        rowStrings.add("");
      }
      for (int i = 0; i <= r; i++) {
        if (board[r][i] == Grid.Empty) {
          rowStrings.add(Grid.Empty.toString());
        } else {
          rowStrings.add(Grid.Marble.toString());
        }
      }
      rows.add(String.join(" ", rowStrings));
    }
    return String.join("\n", rows);
  }

  /**
   * Returns the dimension of this triangle game board with the given length. The dimension of this
   * board is its side length.
   *
   * @param length the length of the board.
   * @return return the dimension
   */
  @Override
  protected int getDimension(int length) {
    return length;
  }

  /**
   * Determines whether the given (r,c) position points to a invalid grid in the triangle board. The
   * invalid grids of a row are located in the columns whose values are greater than the value of
   * its row.
   *
   * @param r the row of the position
   * @param c the column of the position
   * @return true if the given (r,c) position is in the position of {@code grid.Invalid}, else false
   */
  @Override
  protected boolean invalidGridSpace(int r, int c) {
    return r < c;
  }

  /**
   * Determines whether there is possible orthogonal and diagonal move for the grid at the give
   * (r,c) position.
   *
   * @param r the row of the position
   * @param c the column of the position
   * @return true if the grid at the given (r,c) position has a possible move, false otherwise.
   */
  @Override
  protected boolean possibleMove(int r, int c) {
    boolean topDia = this.canMoveTo(r, c, r + 2, c + 2);
    boolean botDia = this.canMoveTo(r, c, r - 2, c - 2);
    return topDia || botDia || super.possibleMove(r, c);
  }

  /**
   * Determines whether (fromRow, fromCol) and (toRow, toCol) positions are on the correct
   * orthogonal axis and the diagonal axis.
   *
   * @param fromRow the row of the first position
   * @param fromCol the column of the first position
   * @param toRow   the row of the second position
   * @param toCol   the column of the second position
   * @return true of these positions are orthogonal or diagonal to another.
   */
  @Override
  protected boolean onCorrectAxis(int fromRow, int fromCol, int toRow, int toCol) {
    boolean top = fromRow + 2 == toRow && fromCol + 2 == toCol;
    boolean bot = fromRow - 2 == toRow && fromCol - 2 == toCol;
    return !top && !bot && super.onCorrectAxis(fromRow, fromCol, toRow, toCol);
  }

  /**
   * Determines whether the distance between the (fromRow, fromCol) and (toRow, toCol) positions is
   * 2(orthogonal) or 2.828(diagonal).
   *
   * @param fromRow the row of the first position
   * @param fromCol the column of the first position
   * @param toRow   the row of the second position
   * @param toCol   the column of the second position
   * @return true if the distance between the given positions is 2 or 2.828, else false.
   */
  @Override
  protected boolean isGap(int fromRow, int fromCol, int toRow, int toCol) {
    double distance = distance(fromRow, fromCol, toRow, toCol);
    return super.isGap(fromRow, fromCol, toRow, toCol) || Math.abs(distance - 2.828) < 0.001;
  }


  /**
   * Throws error when the given length is invalid for this game board.
   *
   * @param length of the game board
   * @throws IllegalArgumentException if the given length is even or equal to one.
   */
  @Override
  protected void isValidLength(int length) {
    // Checking whether the desired length is valid for triangle
    if (length < 1) {
      throw new IllegalArgumentException("The Given Length Must Be Greater Than And Equal To One");
    }
  }

}
