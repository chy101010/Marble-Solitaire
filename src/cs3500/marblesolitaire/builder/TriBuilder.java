package cs3500.marblesolitaire.builder;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

/**
 * Represents a Triangular Marble Solitaire Builder that allows the client to construct a configured
 * or default triangular game board.
 */
public class TriBuilder extends MarbleAbstractBuilder {

  /**
   * Constructs a TriBuilder with the default configurations of a Triangular Marble Solitaire.
   */
  public TriBuilder() {
    this.length = 5;
    this.r = 0;
    this.c = 0;
  }

  /**
   * The centering in the abstract method isn't needed.
   *
   * @return MarbleSolitaireModel with the desired configuration
   */
  @Override
  public MarbleSolitaireModel create() {
    return this.factory();
  }

  /**
   * Construct a configured TriangleSolitaireModelImpl.
   *
   * @return TriangleSolitaireModelImpl
   */
  @Override
  protected MarbleSolitaireModel factory() {
    return new TriangleSolitaireModelImpl(this.length, this.r, this.c);
  }
}