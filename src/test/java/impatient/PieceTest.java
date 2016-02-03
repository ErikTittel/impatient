package impatient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class PieceTest {

    @Test(expected = IllegalArgumentException.class)
    public void initPieceNullParts() {
        new Piece(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initPieceEmptyParts() {
        new Piece(new HashSet<>());
    }

    @Test
    public void pieceSameFormOnePart() {
        Set<Vector> parts = new HashSet<>();
        parts.add(new Vector(0, 0, 0));
        Piece piece1 = new Piece(parts);
        Piece piece2 = new Piece(parts);

        assertThat(piece1.isSameForm(piece2), is(true));
    }

    @Test
    public void pieceSameFormTwoParts() {
        Set<Vector> parts = new HashSet<>();
        parts.add(new Vector(0, 0, 0));
        parts.add(new Vector(1, 0, 0));
        Piece piece1 = new Piece(parts);
        Piece piece2 = new Piece(parts);

        assertThat(piece1.isSameForm(piece2), is(true));
    }

    @Test
    @Ignore("handle shifted pieces")
    public void pieceSameFormOnePartShifted() {
        Set<Vector> parts1 = new HashSet<>();
        parts1.add(new Vector(0, 0, 0));
        Set<Vector> parts2 = new HashSet<>();
        parts2.add(new Vector(1, 0, 0));
        Piece piece1 = new Piece(parts1);
        Piece piece2 = new Piece(parts2);

        assertThat(piece1.isSameForm(piece2), is(true));
    }
}
