package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * A MarbleSolitaireController, it handle user moves by executing them using the model; convey move
 * outcomes to the user in some form.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Appendable ap;
  private final Scanner scan;

  /**
   * Constructs a marble solitaire controller.
   *
   * @param rd readable object
   * @param ap appendable object
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.ap = ap;
    scan = new Scanner(rd);
  }

  @Override
  public void playGame(MarbleSolitaireModel model) {
    if (model == null) {
      throw new IllegalArgumentException("Must pass in a Marble Solitaire");
    }
    try {
      // Prints the initial game
      this.ap.append(this.initialBoard(model) + "\n");
      while (!model.isGameOver()) {
        // Four Valid Inputs Temporary Storage
        List<Integer> inputs = new ArrayList<>();
        // Breaks the while loop once four valid inputs are found
        while (inputs.size() < 4) {
          switch (this.inputProcessor(inputs)) {
            case Invalid:
              this.ap.append("Please enter an valid input!" + "\n");
              continue;
            case NoInput:
              throw new IllegalStateException("No Inputs");
            case Quit:
              this.ap.append(this.outPutFormat(model, "quit"));
              return;
            default:
          }
        }
        try {
          // Move method
          this.moveExecute(inputs, model);
          this.ap.append(this.outPutFormat(model, "move"));
          // Catch invalid move positions
        } catch (IllegalArgumentException e) {
          this.ap.append("Invalid move. Play again. " + e.getMessage() + "\n");
        }
      }
      // Game Over
      this.ap.append(this.outPutFormat(model, "over"));
      return;
      // Catch failing appendable
    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    }
  }


  /**
   * Returns the corresponding formatted with the given message and data from the model.
   *
   * @param model   the marble solitaire model
   * @param message the message indicates what formatted string to be returned
   * @return formatted String with the given message.
   * @throws IllegalArgumentException if the given message is unsupported.
   */
  private String outPutFormat(MarbleSolitaireModel model, String message) {
    String scoreAndBoard = this.initialBoard(model);
    if (message.equals("move")) {
      return scoreAndBoard + "\n";
    } else if (message.equals("quit")) {
      return "Game quit!" + "\n" + "State of game when quit:" + "\n" + scoreAndBoard;
    } else if (message.equals("over")) {
      return "Game over!" + "\n" + scoreAndBoard;
    }
    throw new IllegalArgumentException("Given message isn't supported.");
  }

  /**
   * Returns the initial string representation of the marble solitaire board and score.
   *
   * @param model the marble solitaire model
   * @return the string representation of the board and score.
   */
  private String initialBoard(MarbleSolitaireModel model) {
    return model.getGameState() + "\n" + "Score: " + Integer.toString(model.getScore());
  }


  /**
   * Returns the status of one user argument. Returns {@code NoInput} if there is no user
   * argument,{@code Quit} if the user argument is a character 'q' or "Q",{@code Valid} if the user
   * argument is an integer, and {@code Invalid} if the user argument is a non-integer.
   *
   * @param ar a list of valid Integer stored so far from the user argument
   * @return InputType indicating the status of one user argument.
   */
  private InputType inputProcessor(List<Integer> ar) {
    if (this.scan.hasNext()) {
      String next = this.scan.next();
      if (next.equalsIgnoreCase("q")) {
        return InputType.Quit;
      }
      try {
        ar.add(Integer.parseInt(next) - 1);
        return InputType.Valid;
      } catch (NumberFormatException e) {
        return InputType.Invalid;
      }
    } else {
      return InputType.NoInput;
    }
  }


  /**
   * Executes the marble solitaire move method on the given marble model using the given list of
   * four integers input representing the from and to positions. The integers in the list will be
   * erased.
   *
   * @param inputs list of four integers inputs
   * @param model  the MarbleSolitaireModel
   */
  private void moveExecute(List<Integer> inputs, MarbleSolitaireModel model) {
    List<Integer> copy = this.inputsCopy(inputs);
    inputs.clear();
    // Move method
    model.move(copy.get(0), copy.get(1), copy.get(2), copy.get(3));
    // Clears the used four valid inputs
  }

  /**
   * Return a list copy of the given list inputs.
   *
   * @param inputs list of four integers inputs
   */
  private List<Integer> inputsCopy(List<Integer> inputs) {
    List<Integer> copy = new ArrayList<>();
    for (Integer i : inputs) {
      copy.add(i);
    }
    return copy;
  }

  /**
   * Represents the status of one user argument. {@code Invalid} indicates a non-Integer. {@code
   * Valid} indicates an Integer. {@code Quit} indicates a quiting game character, 'q' or 'Q'.
   * {@code NoInput} indicates there is no inputs.
   */
  private enum InputType { Invalid, Quit, Valid, NoInput }
}
