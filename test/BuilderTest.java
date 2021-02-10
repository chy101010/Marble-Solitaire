

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.marblesolitaire.builder.EnBuilder;
import cs3500.marblesolitaire.builder.EuBuilder;
import cs3500.marblesolitaire.builder.MarbleBuilder;
import cs3500.marblesolitaire.builder.TriBuilder;
import cs3500.marblesolitaire.model.hw02.Grid;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

/**
 * Test cases for the Marble Builder. Verifying that game state is properly managed, and all game
 * actions are properly validated.
 */
public class BuilderTest {

  @Test
  public void defaultBuilder() {
    // Checking TriBuilder
    MarbleSolitaireModel defaultTri = new TriangleSolitaireModelImpl();
    MarbleBuilder buildTri = new TriBuilder();
    assertEquals(defaultTri.getGameState(), buildTri.create().getGameState());

    // Checking EnBuilder
    MarbleSolitaireModel defaultEn = new MarbleSolitaireModelImpl();
    MarbleBuilder buildEn = new EnBuilder();
    assertEquals(defaultEn.getGameState(), buildEn.create().getGameState());

    // Checking EuBuilder
    MarbleSolitaireModel defaultEu = new EuropeanSolitaireModelImpl();
    MarbleBuilder buildEu = new EuBuilder();
    assertEquals(defaultEu.getGameState(), buildEu.create().getGameState());
  }

  @Test
  public void configuredSizeBuilder() {
    // Checking TriBuilder
    MarbleSolitaireModel defaultTri = new TriangleSolitaireModelImpl(3);
    MarbleBuilder buildTri = new TriBuilder();
    buildTri.size(3);
    assertEquals(defaultTri.getGameState(), buildTri.create().getGameState());

    // Checking EnBuilder
    MarbleSolitaireModel defaultEn = new MarbleSolitaireModelImpl(5);
    MarbleBuilder buildEn = new EnBuilder();
    buildEn.size(5);
    assertEquals(defaultEn.getGameState(), buildEn.create().getGameState());

    // Checking EuBuilder
    MarbleSolitaireModel defaultEu = new EuropeanSolitaireModelImpl(7);
    MarbleBuilder buildEu = new EuBuilder();
    buildEu.size(7);
    assertEquals(defaultEu.getGameState(), buildEu.create().getGameState());
  }

  @Test
  public void configuredHoleBuilder() {
    // Checking TriBuilder
    MarbleSolitaireModel defaultTri = new TriangleSolitaireModelImpl(2, 2);
    MarbleBuilder buildTri = new TriBuilder();
    buildTri.hole(2, 2);
    assertEquals(defaultTri.getGameState(), buildTri.create().getGameState());

    // Checking EnBuilder
    MarbleSolitaireModel defaultEn = new MarbleSolitaireModelImpl(3, 4);
    MarbleBuilder buildEn = new EnBuilder();
    buildEn.hole(3, 4);
    assertEquals(defaultEn.getGameState(), buildEn.create().getGameState());

    // Checking EuBuilder
    MarbleSolitaireModel defaultEu = new EuropeanSolitaireModelImpl(5, 4);
    MarbleBuilder buildEu = new EuBuilder();
    buildEu.hole(5, 4);
    assertEquals(defaultEu.getGameState(), buildEu.create().getGameState());
  }

  @Test
  public void fullConfiguredBuilder() {
    // Checking TriBuilder
    MarbleSolitaireModel defaultTri = new TriangleSolitaireModelImpl(4, 2, 2);
    MarbleBuilder buildTri = new TriBuilder();
    buildTri.hole(2, 2);
    buildTri.size(4);
    assertEquals(defaultTri.getGameState(), buildTri.create().getGameState());

    // Checking EnBuilder
    MarbleSolitaireModel defaultEn = new MarbleSolitaireModelImpl(5, 3, 4);
    MarbleBuilder buildEn = new EnBuilder();
    buildEn.hole(3, 4);
    buildEn.size(5);
    assertEquals(defaultEn.getGameState(), buildEn.create().getGameState());

    // Checking EuBuilder
    MarbleSolitaireModel defaultEu = new EuropeanSolitaireModelImpl(7, 5, 4);
    MarbleBuilder buildEu = new EuBuilder();
    buildEu.hole(5, 4);
    buildEu.size(7);
    assertEquals(defaultEu.getGameState(), buildEu.create().getGameState());
  }

  @Test
  public void fullConfiguredBuilder1() {
    assertTrue(new ArrayList<>(Arrays.asList(Grid.Empty)).equals(new ArrayList<>(Arrays.asList(Grid.Empty))));
  }
}
