package cs3500.marblesolitaire.builder;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;


/**
 * Represents a English Marble Solitaire Builder that allows the client to construct a configured or
 * default English game board.
 */
public class EnBuilder extends MarbleAbstractBuilder {

  /**
   * Constructs a EnBuilder with the default configurations of a English Marble Solitaire.
   */
  public EnBuilder() {
    super();
  }

  /**
   * Constructs a configured MarbleSolitaireModelImpl.
   *
   * @return MarbleSolitaireModelImpl
   */
  @Override
  protected MarbleSolitaireModel factory() {
    return new MarbleSolitaireModelImpl(this.length, this.r, this.c);
  }
}
