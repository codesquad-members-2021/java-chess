package chess;

public class ChessGame {
    private final Board board = new Board();

    public Board getBoard() {
        return board;
    }

    public void move(String before, String after) {
        board.move(new Position(before), new Position(after));
    }

    public void start() {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println(board.getResultToPrint());
    }
}

