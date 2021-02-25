package chess;

public class ChessGame {
    private final Board board = new Board();

    public Board getBoard() {
        return board;
    }

    public void initialize() {
        board.initialize();
    }

    public void move(String before, String after) {
        board.move(new Position(before), new Position(after));
    }

}

