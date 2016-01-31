package impatient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class GameTest {

    private final Game game = new Game(2);

    @Test
    public void addOnePiece() {
        Piece piece = new Piece(1);
        Position position = new Position(0, 0);
        game.addPiece(piece, position);

        boolean solved = game.solve();

        assertThat(solved, is(false));
    }

    @Test
    public void addTwoPiecesToCoverTheWholeBoard() {
        game.addPiece(new Piece(2), new Position(0, 0));
        game.addPiece(new Piece(2), new Position(0, 1));

        boolean solved = game.solve();

        assertThat(solved, is(true));
    }
}
