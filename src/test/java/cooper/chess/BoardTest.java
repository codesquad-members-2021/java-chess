package cooper.chess;

import cooper.chess.piece.Color;
import cooper.chess.piece.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cooper.chess.utils.StringUtils.NEW_LINE;
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
        assertEquals(32, board.pieceCount());

        StringBuilder sb = new StringBuilder();
        String blankRank = "........";

        sb.append("RNBQKBNR").append(NEW_LINE);
        sb.append("PPPPPPPP").append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append(blankRank).append(NEW_LINE);
        sb.append("pppppppp").append(NEW_LINE);
        sb.append("rnbqkbnr").append(NEW_LINE);

        assertEquals(
                sb.toString(),
                board.showBoard()
        );
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
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(17, Color.WHITE)),
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(-1, Color.BLACK)),
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(17, Color.BLACK))
        );
    }

    @Test
    @DisplayName("board의 상태를 확인한다.")
    public void getBoardStatusTest() {
        System.out.println(board.showBoard());
    }
}
