package cs3500.marblesolitaire.builder;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

/**
 * Represents a European Marble Solitaire Builder that allows the client to construct a configured
 * or default European game board.
 */
public class EuBuilder extends MarbleAbstractBuilder {

  /**
   * Constructs a EuBuilder with the default configurations of a European Marble Solitaire.
   */
  public EuBuilder() {
    super();
  }

  /**
   * Constructs a configured EuropeanSolitaireModelImpl.
   *
   * @return EuropeanSolitaireModelImpl
   */
  protected MarbleSolitaireModel factory() {
    return new EuropeanSolitaireModelImpl(this.length, this.r, this.c);
  }
}
