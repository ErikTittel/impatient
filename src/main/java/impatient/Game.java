package impatient;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    private Map<Piece, Position> pieces;


    public Game(int boardSize) {
        solutionArea = new Piece(createPartsForSquare(boardSize));
        pieces = new HashMap<>();
    }

    private Set<Position> createPartsForSquare(int dimensions) {
        Set<Position> parts = new HashSet<>();
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                parts.add(new Position(i, j, 0));
            }
        }
        return parts;
    }

    public void addPiece(Piece piece, Position position) {
        this.pieces.put(piece, position);
    }

    public boolean solve() {
        combinePieces();
        return combinedPieces.isSameForm(solutionArea);
    }

    private void combinePieces() {
        Set<Position> parts = new HashSet<>();
        for (Piece piece : pieces.keySet()) {
            parts.addAll(piece.getParts().stream().map(part -> part.plus(pieces.get(piece))).collect(toList()));
        }
        combinedPieces = new Piece(parts);
    }
}
