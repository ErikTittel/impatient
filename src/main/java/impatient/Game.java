package impatient;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    /**
     * The game is won when the solution Area is completely covered with parts of pieces and no part of any piece lies
     * without the solution area.
     */
    private Piece solutionArea;
    /**
     * The combination of all added pieces. If the combinedPieces match the solutionArea the game is won.
     */
    private Piece combinedPieces;
    private List<Piece> pieces;


    public Game(int boardSize) {
        solutionArea = new Piece(createPartsForSquare(boardSize));
        pieces = new ArrayList<>();
    }

    private Set<Vector> createPartsForSquare(int dimensions) {
        Set<Vector> parts = new HashSet<>();
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                parts.add(new Vector(i, j, 0));
            }
        }
        return parts;
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public boolean solve() {
        combinePieces();
        return combinedPieces.isSameForm(solutionArea);
    }

    private void combinePieces() {
        Set<Vector> parts = new HashSet<>();
        for (Piece piece : pieces) {
            parts.addAll(piece.getParts().stream().map(part -> part.add(piece.getPosition())).collect(toList()));
        }
        combinedPieces = new Piece(parts);
    }
}
