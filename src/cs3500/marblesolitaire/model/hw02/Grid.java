package cs3500.marblesolitaire.model.hw02;


/**
 * Represents a grid in the game of marble solitaire that they are Invalid grid,
 * Marble grid, and Empty grid.
 */
public enum Grid {
  Invalid(" "), Marble("O"), Empty("_");

  private final String state;

  Grid(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return this.state;
  }
}
