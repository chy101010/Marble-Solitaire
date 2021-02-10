package cs3500.marblesolitaire.model.hw02;

import java.util.Objects;

/**
 * A mockup model to test the communication between Model and Controller, checking whether the
 * controller is calling the method move with the correct inputs.
 */
public class ConfirmInputsMove implements MarbleSolitaireModel {
  final StringBuilder log;

  /**
   * Constructs a ConfirmInputsMove.
   *
   * @param log the StringBuilder that to be edited with the inputs once the Controller called
   *            Move.
   */
  public ConfirmInputsMove(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * Appends and formats the inputs into its StringBuilder.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %d\n",
            fromRow, fromCol, toRow, toCol));
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    return null;
  }

  @Override
  public int getScore() {
    return 0;
  }
}
