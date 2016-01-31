package impatient;

public class Game {

    private boolean[][] board;

    public Game(int boardSize) {
        board = new boolean[boardSize][];
        for (int i = 0; i < boardSize; i++) {
            board[i] = new boolean[boardSize];
        }
    }

    public void addPiece(Piece piece, Position position) {
        for (int i = 0; i < piece.length; i++) {
            board[position.x + i][position.y] = true;
        }
    }

    public boolean solve() {
        for (boolean[] line : board) {
            for (boolean field : line) {
                if (!field) {
                    return false;
                }
            }
        }
        return true;
    }
}
