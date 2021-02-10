package cs3500.marblesolitaire;

import java.io.InputStreamReader;
import java.util.Scanner;

import cs3500.marblesolitaire.builder.EnBuilder;
import cs3500.marblesolitaire.builder.EuBuilder;
import cs3500.marblesolitaire.builder.MarbleBuilder;
import cs3500.marblesolitaire.builder.TriBuilder;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;

/**
 * Run a Marble Solitaire game interactively on the console.
 */
public final class MarbleSolitaire {
  /**
   * Process the give user command arguments and initialize an interactive marble solitaire game.
   * User can construct the desired game board with proper command. To start a game of a game of
   * default english board, user should pass in a string array of ["english"], or ["triangular"] for
   * triangular board, or ["european"] for european board. The user can configure the dimension of
   * the board by passing along ["-size x"], or configure the initial hole position by passing along
   * in ["-hole x y"]. Only the latest argument will executed.
   *
   * @param args client arguments.
   * @throws IllegalArgumentException if the given {@code r}, {@code c}, and {@code size} are
   *                                  invalid for the desired marble game boar -constructors
   * @throws IllegalStateException    when the appendable failed to append or readable failed to
   *                                  read inputs - playGame
   */
  public static void main(String[] args) {
    String inputs = String.join(" ", args);
    Scanner scan = new Scanner(inputs);
    MarbleBuilder builder = null;

    // Default Length
    Integer r = null;
    Integer c = null;
    Integer size = null;

    // Constructs the correct Marble Implementation builder.
    while (scan.hasNext()) {
      String str = scan.next();
      switch (str) {
        case "english":
          builder = new EnBuilder();
          break;
        case "triangular":
          builder = new TriBuilder();
          break;
        case "european":
          builder = new EuBuilder();
          break;
        default:
          if (str.equals("-hole")) {
            r = scan.nextInt();
            c = scan.nextInt();
          }
          if (str.equals("-size")) {
            size = scan.nextInt();
          }
      }
    }

    // start the game
    initializeGame(builder, r, c, size);
  }

  /**
   * Initializes an interactive marble solitaire with the given specified marble builder, desired
   * board size, and position for the initial hole. The game will not initialize if the given
   * builder is null. The hole position will be default if the given (r,c) is null. The size will be
   * default if the given size is null.
   *
   * @param builder to construct the desired marble game board.
   * @param r       row of the initial hole position.
   * @param c       column of the initial hole position.
   * @param size    size of the board.
   * @throws IllegalArgumentException if the given {@code r}, {@code c}, and {@code size} are
   *                                  invalid for the desired marble game board.
   * @throws IllegalStateException    when the appendable failed to append or readable failed to
   *                                  read inputs.
   */
  private static void initializeGame(MarbleBuilder builder, Integer r, Integer c, Integer size) {
    // Checking whether there is a builder
    if (builder != null) {
      // Configure the hole only if the it isn't default
      if (r != null && c != null) {
        builder.hole(r, c);
      }
      // Configure the size only if the it isn't default
      if (size != null) {
        builder.size(size);
      }
      new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),
              System.out).playGame(builder.create());
    }
  }
}
