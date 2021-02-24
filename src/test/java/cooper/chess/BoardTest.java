package cooper.chess;

import cooper.chess.piece.Color;
import cooper.chess.piece.Piece;
import cooper.chess.piece.Type;
import org.assertj.core.api.Assert;
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
    @DisplayName("board의 상태를 확인한다.")
    public void getBoardStatusTest() {
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("원하는 색상과 기물의 수를 확인할 수 있다")
    public void getPieCountTest() {
        assertAll(
                () -> verifyPieceCount(Color.WHITE, Type.PAWN, 8),
                () -> verifyPieceCount(Color.WHITE, Type.KNIGHT, 2),
                () -> verifyPieceCount(Color.WHITE, Type.ROOK, 2),
                () -> verifyPieceCount(Color.WHITE, Type.BISHOP, 2),
                () -> verifyPieceCount(Color.WHITE, Type.QUEEN, 1),
                () -> verifyPieceCount(Color.WHITE, Type.KING, 1),

                () -> verifyPieceCount(Color.BLACK, Type.PAWN, 8),
                () -> verifyPieceCount(Color.BLACK, Type.KNIGHT, 2),
                () -> verifyPieceCount(Color.BLACK, Type.ROOK, 2),
                () -> verifyPieceCount(Color.BLACK, Type.BISHOP, 2),
                () -> verifyPieceCount(Color.BLACK, Type.QUEEN, 1),
                () -> verifyPieceCount(Color.BLACK, Type.KING, 1)
        );
    }

    void verifyPieceCount(final Color color, final Type type, final int count) {
        assertEquals(board.getPieceCount(color, type), count);
    }
}
