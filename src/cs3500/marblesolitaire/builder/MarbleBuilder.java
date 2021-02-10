package cs3500.marblesolitaire.builder;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * An Marble Solitaire Builder Interface. Allowing the clients to create a size and hole configured
 * Marble Solitaire Model. Currently supporting English, European, and Triangular version.
 */
public interface MarbleBuilder {

  /**
   * Constructs a MarbleSolitaireModel with the desired configuration and type.
   *
   * @return MarbleSolitaireModel
   */
  MarbleSolitaireModel create();

  /**
   * Allows the user to get the desired size of the game board.
   *
   * @param size of the game board.
   */
  void size(int size);


  /**
   * Allows the user to get the desired position for the initial empty spot on the game board.
   *
   * @param r position of the row
   * @param c position of the column
   */
  void hole(int r, int c);
}
