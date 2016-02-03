package impatient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class GameTest {

    private final Game game = new Game(2);

    @Test
    public void addOnePiece() {
        Set<Vector> parts = new HashSet<>();
        parts.add(new Vector(0, 0, 0));
        parts.add(new Vector(1, 0, 0));
        Piece piece = new Piece(parts).position(new Vector(0, 0, 0));
        game.addPiece(piece);

        boolean solved = game.solve();

        assertThat(solved, is(false));
    }

    @Test
    public void addTwoPiecesToCoverTheWholeBoard() {
        Set<Vector> parts = new HashSet<>();
        parts.add(new Vector(0, 0, 0));
        parts.add(new Vector(1, 0, 0));
        Piece piece = new Piece(parts).position(new Vector(0, 0, 0));
        game.addPiece(piece);
        Set<Vector> parts2 = new HashSet<>();
        parts2.add(new Vector(0, 0, 0));
        parts2.add(new Vector(1, 0, 0));
        Piece piece2 = new Piece(parts2).position(new Vector(0, 1, 0));
        game.addPiece(piece2);

        boolean solved = game.solve();

        assertThat(solved, is(true));
    }
}
