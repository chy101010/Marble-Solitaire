package cs3500.marblesolitaire.builder;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents an Abstract class for Marble Solitaire Models Builders. It supports methods that allow
 * users to create a Marble solitaire Model by configuring size and position of initial hole.
 */
public abstract class MarbleAbstractBuilder implements MarbleBuilder {
  protected int length;
  protected int r;
  protected int c;

  /**
   * Default configurations for European and English model.
   */
  protected MarbleAbstractBuilder() {
    this.length = 3;
    this.r = 3;
    this.c = 3;
  }

  @Override
  public void size(int size) {
    this.length = size;
  }

  @Override
  public void hole(int r, int c) {
    this.r = r;
    this.c = c;
  }

  /**
   * Construct a MarbleSolitaireModel with this size and an initial hole at (r,c) position. If the
   * client is an EnBuilder and EuBuilder, this method will check whether the hole and size is
   * configured. If the hole isn't configured but the size is, it will center the hole.
   *
   * @return MarbleSolitaireModel with the desired configuration
   */
  @Override
  public MarbleSolitaireModel create() {
    if (length != 3 && r == 3 && c == 3) {
      int mid = (3 * length - 3) / 2;
      this.r = mid;
      this.c = mid;
    }
    return factory();
  }

  /**
   * Construct the respective configured MarbleSolitaireModel.
   *
   * @return configured MarbleSolitaireModel.
   */
  protected abstract MarbleSolitaireModel factory();
}
