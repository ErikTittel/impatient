package impatient;

import java.util.Set;

public class Piece {

    public Set<Position> parts;

    public Piece(Set<Position> parts) {
        if (parts == null || parts.isEmpty()) {
            throw new IllegalArgumentException("A piece needs some parts");
        }
        this.parts = parts;
    }

    public boolean isSameForm(Piece other) {
        return parts.equals(other.parts);
    }

    public Set<Position> getParts() {
        return parts;
    }

    @Override
    public boolean equals(Object o) {
        // each instance has it's own identity
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        // each instance has it's own identity
        return super.hashCode();
    }
}
