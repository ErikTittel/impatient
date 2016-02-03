package impatient;

import java.util.HashSet;
import java.util.Set;

public class Piece {

    private Set<Vector> parts;
    private Vector position;

    public Piece(Set<Vector> parts) {
        if (parts == null || parts.isEmpty()) {
            throw new IllegalArgumentException("A piece needs some parts");
        }
        this.parts = new HashSet<>(parts);
    }

    public boolean isSameForm(Piece other) {
        return parts.equals(other.parts);
    }

    public Set<Vector> getParts() {
        return parts;
    }

    public Vector getPosition() {
        return position;
    }

    public Piece position(Vector position) {
        this.position = position;
        return this;
    }
}
