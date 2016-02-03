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
        Set<Position> parts = new HashSet<>();
        parts.add(new Position(0, 0, 0));
        parts.add(new Position(1, 0, 0));
        Piece piece = new Piece(parts);
        Position position = new Position(0, 0, 0);
        game.addPiece(piece, position);

        boolean solved = game.solve();

        assertThat(solved, is(false));
    }

    @Test
    public void addTwoPiecesToCoverTheWholeBoard() {
        Set<Position> parts = new HashSet<>();
        parts.add(new Position(0, 0, 0));
        parts.add(new Position(1, 0, 0));
        Piece piece = new Piece(parts);
        Position position = new Position(0, 0, 0);
        game.addPiece(piece, position);
        Set<Position> parts2 = new HashSet<>();
        parts2.add(new Position(0, 0, 0));
        parts2.add(new Position(1, 0, 0));
        Piece piece2 = new Piece(parts2);
        Position position2 = new Position(0, 1, 0);
        game.addPiece(piece2, position2);

        boolean solved = game.solve();

        assertThat(solved, is(true));
    }
}
