package cs3500.marblesolitaire.model.hw04;


/**
 * Represents European marble solitaire model, supported methods that allow user to make a valid
 * orthogonal move, get the string representation of the board, check whether the game is over, and
 * get the score. This is a sub-class of {@code MarbleAbstract} with unique positions for {@code
 * Grid.Invalid} and {@code Grid.Marble}.
 */
public class EuropeanSolitaireModelImpl extends MarbleAbstract {
  /**
   * Constructs an European Marble GameBoard with given arm thick and an initial empty spot at
   * (r,c).
   *
   * @param length the arm length of the game board
   * @param r      the row position to place the empty spot
   * @param c      the column position to place the empty spot
   * @throws IllegalArgumentException if the given (r,c) position is an invalid empty spot or if the
   *                                  given {@code thick} is 1 or even.
   */
  public EuropeanSolitaireModelImpl(int length, int r, int c) {
    super(length, r, c);
  }

  /**
   * Constructs an European Marble GameBoard with a board length of 3 with an empty spot at the
   * given the (r,c) position.
   *
   * @param r the row position to place the empty grid
   * @param c the column position to place the empty spot
   * @throws IllegalArgumentException if the given (r,c) position is an invalid spot for empty
   *                                  grid.
   */
  public EuropeanSolitaireModelImpl(int r, int c) {
    this(3, r, c);
  }

  /**
   * Constructs an European Marble GameBoard with the given board length with a centered empty
   * spot.
   *
   * @throws IllegalArgumentException if the given {@code length} is 1 or even
   */
  public EuropeanSolitaireModelImpl(int length) {
    this(length, mid(length), mid(length));
  }

  /**
   * Constructs a default European Marble GameBoard with a board length of 3 and a centered empty
   * spot at position (3,3).
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3, 3);
  }


  /**
   * Determines whether the given (r,c) position points to a invalid grid in the board, invalid
   * grids are in the top-left, top-right, bottom-left, and bottom-right triangle corner of the
   * board.
   *
   * @param r the row of the point
   * @param c the column of the point
   * @return true if the given (r,c) position is in the position of {@code Grid.Invalid}, else false
   */
  @Override
  protected boolean invalidGridSpace(int r, int c) {
    int start = start(this.dimension);
    int end = end(this.dimension);
    // Top Portion
    if (r < start) {
      return !(start - r <= c && c <= end + r);
    }
    // Bottom Portion
    else if (r > end) {
      return !(start - this.dimension + r + 1 <= c && c <= end + this.dimension - r - 1);
    }
    return !(start <= r && r <= end);
  }


}
