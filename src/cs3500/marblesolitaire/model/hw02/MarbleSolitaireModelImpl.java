package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.MarbleAbstract;

/**
 * Represents English marble solitaire model, supported methods that allow user to make a valid
 * orthogonal move, get the string representation of the board, check whether the game is over, and
 * get the score. This is a sub-class of {@code MarbleAbstract} with unique positions for {@code
 * Grid.Invalid} and {@code Grid.Marble}.
 */
public class MarbleSolitaireModelImpl extends MarbleAbstract {
  /**
   * Constructs am English Marble GameBoard with given arm thick and an initial empty spot at
   * (r,c).
   *
   * @param thick the arm thick of the game board
   * @param r     the row position to place the empty spot
   * @param c     the column position to place the empty spot
   * @throws IllegalArgumentException if the given (r,c) position is an invalid empty spot or if the
   *                                  given {@code thick} is 1 or even.
   */
  public MarbleSolitaireModelImpl(int thick, int r, int c) {
    super(thick, r, c);
  }


  /**
   * Constructs a default English Marble GameBoard with arm thick of 3 and a centered empty spot at
   * position (3,3).
   */
  public MarbleSolitaireModelImpl() {
    this(3, 3, 3);
  }

  /**
   * Constructs an English Marble GameBoard with arm thick of 3 with an empty spot at the given the
   * (r,c) position.
   *
   * @param r the row position to place the empty grid
   * @param c the column position to place the empty spot
   * @throws IllegalArgumentException if the given (r,c) position is an invalid spot for empty
   *                                  grid.
   */
  public MarbleSolitaireModelImpl(int r, int c) {
    this(3, r, c);
  }

  /**
   * Constructs an English Marble GameBoard with the given arm thick with a centered empty spot.
   *
   * @param thick the arm thick of the game board
   * @throws IllegalArgumentException if the given {@code thick} is 1 or even
   */
  public MarbleSolitaireModelImpl(int thick) {
    this(thick, mid(thick), mid(thick));
  }


  /**
   * Determines whether the given (r,c) position points to a invalid grid in the board, invalid
   * grids are in the top-left, top-right, bottom-left, and bottom-right square corner of the
   * board.
   *
   * @param r the row of the point
   * @param c the column of the point
   * @return true if the given (r,c) position is in the position of {@code grid.Invalid}, else false
   */
  @Override
  protected boolean invalidGridSpace(int r, int c) {
    int start = start(this.dimension);
    int end = end(this.dimension);
    boolean topLeft = r < start && c < start;
    boolean topRight = r < start && c > end;
    boolean bottomLeft = r > end && c < start;
    boolean bottomRight = r > end && c > end;
    return topLeft || topRight || bottomLeft || bottomRight;
  }

}


