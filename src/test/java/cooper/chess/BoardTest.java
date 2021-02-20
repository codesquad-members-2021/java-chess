package cooper.chess;

import cooper.chess.piece.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("모든 기물이 생성됨을 확인한다.")
    public void create() {
        board.initialize();

        assertEquals(32, board.pieceCount());

        StringBuilder sb = new StringBuilder();
        String blankRank = "........";

        sb.append("RNBQKBNR").append("\n");
        sb.append("PPPPPPPP").append("\n");
        sb.append(blankRank).append("\n");
        sb.append(blankRank).append("\n");
        sb.append(blankRank).append("\n");
        sb.append(blankRank).append("\n");
        sb.append("pppppppp").append("\n");
        sb.append("rnbqkbnr").append("\n");

        assertEquals(
                sb.toString(),
                board.showBoard()
        );
    }

    @Test
    @DisplayName("board 사이즈가 0일 때의 예외를 발생시킨다.")
    public void testZeroSizeOfBoard() {
        assertThrows(IllegalArgumentException.class,
                () -> board.findPawn(0, Color.WHITE));
    }

    @Test
    @DisplayName("index 외에 값을 입력이 예외를 발생시킨다.")
    public void testOutOfBoardSize() {
        Piece white = Piece.createWhitePawn();
        board.add(white);

        Piece black = Piece.createBlackPawn();
        board.add(black);

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(-1, Color.WHITE)),
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(3, Color.BLACK))
        );
    }

    @Test
    @DisplayName("board의 상태를 확인한다.")
    public void getBoardStatusTest() {
        board.initialize();
        System.out.println(board.showBoard());
    }
}
