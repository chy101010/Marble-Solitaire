package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

import cs3500.marblesolitaire.model.hw02.Grid;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an Abstract class for Marble Solitaire Models. It supports methods that allow users to
 * make a valid orthogonal move, get the string representation of the board, check whether the game
 * is over, get the score.
 */
public abstract class MarbleAbstract implements MarbleSolitaireModel {
  // Protected fields used by existence sub-classes.
  protected int dimension; // dimension of the game board
  protected Grid[][] board; // 2-D arrays of {@code Grid} representation of the game board
  protected int score;

  /**
   * Protected: This constructor is invoked by all sub-classes.
   *
   * <p>Constructs an Marble GameBoard with given arm thick or length and an initial empty spot at
   * (r,c). It puts the {@code Grid.Invalid} and {@code Grid.Marble} at the correct spots determined
   * by the sub-class clients.
   *
   * @param length the length of the game board
   * @param r      the row position to place the empty spot
   * @param c      the column position to place the empty spot
   * @throws IllegalArgumentException if the given (r,c) position is an invalid empty spot. If the
   *                                  given {@code length} is invalid for the board.
   */
  protected MarbleAbstract(int length, int r, int c) {
    // getting the dimension of the respective board.
    // getDimension method should override in subclass, except for EuropeanSolitaireModelImpl
    // and MarbleSolitaireModelImpl.
    this.dimension = this.getDimension(length);


    // checking whether the given (r,c) position could be an empty Grid, only if (r,c) is
    // out of bound or in the invalid Grid.
    // invalidGridSpace method should override in all subclass.
    if (this.invalidGridSpace(r, c) || this.outOfBound(r, c)) {
      throw new IllegalArgumentException("Invalid empty cell position "
              + "(" + r + "," + c + ")");
    }

    // Validated - length and empty position
    // constructs a 2D array representation of the board with {@code Invalid} and {@code Marble} and
    // {@code Empty}
    this.board = this.gridBuilder(length, r, c);
  }

  /**
   * Addition Information that the Interface didn't cover. Decreases the {@code score} count if a
   * valid move is made.
   *
   * @throws IllegalArgumentException if either one of the positions is out of bound or points to an
   *                                  {@code Grid.Invalid}, or the positions are not on the correct
   *                                  axis or the distance is incorrect, or the first position is
   *                                  not a {@code Grid.Marble} or the second position is not an
   *                                  {@code Grid.Empty} or the position in between is not a {@code
   *                                  Grid.Marble}.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    int rowBetween = inBetween(fromRow, toRow);
    int colBetween = inBetween(fromCol, toCol);
    // Validating whether the move is possible
    if (this.isValidMove(fromRow, fromCol, toRow, toCol)) {
      this.board[fromRow][fromCol] = Grid.Empty;
      this.board[rowBetween][colBetween] = Grid.Empty;
      this.board[toRow][toCol] = Grid.Marble;
      score--;
    }
  }

  @Override
  public boolean isGameOver() {
    for (int r = 0; r < this.board.length; r++) {
      for (int c = 0; c < this.board.length; c++) {
        if (this.possibleMove(r, c)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public String getGameState() {
    List<String> rows = new ArrayList<>();
    for (Grid[] row : this.board) {
      List<String> rowStrings = new ArrayList<>();
      for (int i = 0; i < row.length; i++) {
        if (row[i] == Grid.Marble) {
          rowStrings.add(Grid.Marble.toString());
        } else if (row[i] == Grid.Empty) {
          rowStrings.add(Grid.Empty.toString());
        } else {
          // only accounts for the left side of the invalid grid.
          if (row[i] == Grid.Invalid && i < start(dimension)) {
            rowStrings.add(Grid.Invalid.toString());
          }
        }
      }
      rows.add(String.join(" ", rowStrings));
    }
    return String.join("\n", rows);
  }

  @Override
  public int getScore() {
    return this.score;
  }

  /**
   * Protected: Implementations have unique positions for {@code Grid.Invalid}, and thus this method
   * is deferred subclasses.
   *
   * <p>Determines whether the given (r,c) position points to a invalid Grid in the respective
   * board.
   *
   * @param r the row of the point
   * @param c the column of the point
   * @return true if the given (r,c) position is in the place of {@code Grid.Invalid}, else false
   */
  protected abstract boolean invalidGridSpace(int r, int c);


  /**
   * Protected: TriangleSolitaireModelImpl overrides this method.
   *
   * <p>Throws error when the given length is invalid for the game board. This works for
   * EuropeanSolitaireModelImpl and MarbleSolitaireModelImpl board.
   *
   * @param length of the  game board
   * @throws IllegalArgumentException if the given length is even or equal to one
   */
  protected void isValidLength(int length) {
    // Checking whether the desired length or arm thick is valid for European/English
    if (length % 2 == 0 || length == 1) {
      throw new IllegalArgumentException("The thickness should be odd value greater than 1");
    }
  }

  /**
   * Protected: TriangleSolitaireModelImpl overrides this method.
   *
   * <p>Determines whether the distance between (fromRow, fromCol) and (toRow, toCol) positions is
   * two or one position a part.
   *
   * @param fromRow the row of the first position
   * @param fromCol the column of the first position
   * @param toRow   the row of the second position
   * @param toCol   the column of the second position
   * @return true if the distance between the given positions is two, else false
   */
  protected boolean isGap(int fromRow, int fromCol, int toRow, int toCol) {
    return Math.abs(distance(fromRow, fromCol, toRow, toCol) - 2.0) < 0.001;
  }

  /**
   * Protected: TriangleSolitaireModelImpl overrides this method.
   *
   * <p>Determines whether (fromRow, fromCol) and (toRow, toCol) positions are on the same
   * orthogonal axis.
   *
   * @param fromRow the row of the first position
   * @param fromCol the column of the first position
   * @param toRow   the row of the second position
   * @param toCol   the column of the second position
   * @return true if the positions are on the same orthogonal axis, else false
   */
  protected boolean onCorrectAxis(int fromRow, int fromCol, int toRow, int toCol) {
    boolean sameRow = fromRow == toRow;
    boolean sameCol = fromCol == toCol;
    return !sameRow && !sameCol;
  }

  /**
   * Protected: TriangleSolitaireModelImpl overrides this method.
   *
   * <p>Determines whether there is possible orthogonal move for the grid at the give (r,c)
   * position.
   *
   * @param r the row of the position
   * @param c the column of the position
   * @return true if the grid at the given (r,c) position has a possible orthogonal move, else false
   */
  protected boolean possibleMove(int r, int c) {
    boolean top = this.canMoveTo(r, c, r + 2, c);
    boolean bottom = this.canMoveTo(r, c, r - 2, c);
    boolean left = this.canMoveTo(r, c, r, c - 2);
    boolean right = this.canMoveTo(r, c, r, c + 2);
    return top || bottom || left || right;
  }

  /**
   * Protected: TriangleSolitaireModelImpl invoked this method.
   *
   * <p>Determines whether it is possible to operate a move on the given grid at (fromR, fromC)
   * position to (toR, toC) position.
   *
   * @param fromR the row of the initial position
   * @param fromC the column of the initial position
   * @param toR   the row of the end position
   * @param toC   the column of the end position
   * @return true if the grid at (fromR, fromC) can be moved to (toR, toC), false otherwise.
   */
  protected boolean canMoveTo(int fromR, int fromC, int toR, int toC) {
    try {
      return this.isValidMove(fromR, fromC, toR, toC);
    } catch (IllegalArgumentException ie) {
      return false;
    }
  }

  /**
   * Protected: TriangleSolitaireModelImpl overrides this method.
   *
   * <p>Calculate the dimension of the board given length or arm thick. This abstracted method
   * works for European/English Board.
   *
   * @param length the length or arm thick of the board.
   * @return the dimension of the board.
   */
  protected int getDimension(int length) {
    return (2 * length) + length - 2;
  }

  /**
   * Protected: EuropeanSolitaireModelImpl and MarbleSolitaireModelImpl invoke this method.
   *
   * <p>Returns the index of the top/bottom left-most {@code Grid.Marble} of the board. This
   * abstracted method works for European/English Board.
   *
   * @param dim dimension of the board
   * @return an int that
   */
  protected static int start(int dim) {
    return (dim + 2) / 3 - 1;
  }

  /**
   * Protected: EuropeanSolitaireModelImpl and MarbleSolitaireModelImpl invoke this method.
   *
   * <p>Returns the index of the top/bottom right-most {@code Grid.Marble} of the board. This
   * abstracted method works for European/English Board.
   *
   * @param dim dimension of the board
   * @return an int that
   */
  protected static int end(int dim) {
    return start(dim) * 2;
  }

  /**
   * Protected: EuropeanSolitaireModelImpl and MarbleSolitaireModelImpl invoke this method.
   *
   * <p>Returns the middle index of the board. This works for European/English Board. This
   * abstracted method works for European/English Board.
   *
   * @param len arm thick or side length of the board.
   * @return an int that is the middle index of the board.
   */
  protected static int mid(int len) {
    return (3 * len - 3) / 2;
  }

  /**
   * Protected: TriangleSolitaireModelImpl invokes this method.
   *
   * <p>Calculates the distance between (fromRow, fromCol) and (toRow, toCol) positions.
   *
   * @param fromRow the row of the first position
   * @param fromCol the column of the first position
   * @param toRow   the row of the second position
   * @param toCol   the column of the second position
   * @return a double that is the distance between the given positions
   */
  protected static double distance(int fromRow, int fromCol, int toRow, int toCol) {
    return Math.sqrt(Math.pow(fromRow - toRow, 2) + Math.pow(fromCol - toCol, 2));
  }

  /**
   * Computes the average of the two given integers.
   *
   * @param from first integer
   * @param to   second integer
   * @return the average of given integers
   */
  private static int inBetween(int from, int to) {
    return (from + to) / 2;
  }

  /**
   * Determines whether the given (r,c) position is out of the bound of the game board, greater than
   * or less than its dimension.
   *
   * @param r the row of the position
   * @param c the column of the position
   * @return true if the given (r,c) is out of the range of the board, false otherwise.
   */
  private boolean outOfBound(int r, int c) {
    return r < 0 || c < 0 || r >= this.dimension || c >= this.dimension;
  }

  /**
   * Constructs a 2D array of {@code Grid} representing the marble game board with an {@code
   * Grid.Empty} at the given (row, col). It fills the invalid places with {@code Grid.Invalid},
   * valid places with {@code Grid.Marble}, and keeps track the marble placed.
   *
   * @param row the row position to place the empty Grid
   * @param col the column position to place empty Grid position
   * @return a game board in the representation of {@code Grid[][]}
   * @throws IllegalArgumentException if the given length is invalid for the game board
   */
  private Grid[][] gridBuilder(int length, int row, int col) {
    this.isValidLength(length);
    Grid[][] board = new Grid[this.dimension][this.dimension];
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board.length; c++) {
        if (this.invalidGridSpace(r, c)) {
          board[r][c] = Grid.Invalid;
        } else {
          board[r][c] = Grid.Marble;
          this.score++;
        }
      }
    }
    this.score--;
    board[row][col] = Grid.Empty;
    return board;
  }


  /**
   * Determines whether the given positions are in the range of the board and in the
   * correct(orthogonal) axis with one position in between them and the first position must points
   * to a marble and the second points to an empty Grid.
   *
   * @param fromRow the row of the first position
   * @param fromCol the column of the first position
   * @param toRow   the row of the second position
   * @param toCol   the column of the second position
   * @return returns true if the move is valid, throws exception otherwise.
   * @throws IllegalArgumentException if either one of the positions is out of bound or points to an
   *                                  {@code Grid.Invalid}, or the positions are not on the correct
   *                                  axis or the distance is incorrect , or the first position is
   *                                  not a {@code Grid.Marble} or the second position is not an
   *                                  {@code Grid.Empty} or the position in between is not a {@code
   *                                  Grid.Marble}.
   */
  private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    // Validating positions: checking whether these given positions are in the
    // range of the game board(off the board or invalid spaces)
    if (this.outOfBound(fromRow, fromCol) || this.outOfBound(toRow, toCol)) {
      throw new IllegalArgumentException("At least one of the positions is "
              + "out of the board");
    }
    // Validating positions: checking whether these given positions are pointing to invalid spaces
    else if (this.invalidGridSpace(fromRow, fromCol) || this.invalidGridSpace(toRow, toCol)) {
      throw new IllegalArgumentException("An Invalid Grid is selected");
    }
    // Validating positions: checking whether these given positions are in correct distance.
    else if (!(this.isGap(fromRow, fromCol, toRow, toCol))) {
      throw new IllegalArgumentException("The gap between these two positions is incorrect amount");
    }
    // Validating positions: checking whether these given positions are on the correct axis.
    else if (this.onCorrectAxis(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("The positions are not on the correct axis");
    }
    // checking whether the first position points to a {@code Marble} and the
    // second position points to a {@code Empty}
    else if (this.board[fromRow][fromCol] != Grid.Marble
            || this.board[toRow][toCol] != Grid.Empty) {
      throw new IllegalArgumentException("Must first select a Marble then an Empty grid");
    } else {
      // checking whether the middle position points to a {@code Marble}
      if (this.board[inBetween(fromRow, toRow)]
              [inBetween(fromCol, toCol)] != Grid.Marble) {
        throw new IllegalArgumentException("The grid in between isn't a Marble");
      }
      return true;
    }
  }


}
