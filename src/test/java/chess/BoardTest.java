package chess;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Type;

import static utils.StringUtils.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void testInit() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("게임 보드 초기화")
    void initialize() throws Exception {
        String blankRank = appendNewLine("........");
        String initBoard =
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr");

        assertThat(board.pieceCount()).as("Board Size").isEqualTo(32);
        assertThat(board.showBoard()).as("Board Initial State").isEqualTo(initBoard);
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("게임 보드 내의 체스말을 종류별로 세기")
    void countPieceByColorAndType() {
        countPieceByType(Type.PAWN, 8);
        countPieceByType(Type.KNIGHT, 2);
        countPieceByType(Type.ROOK, 2);
        countPieceByType(Type.BISHOP, 2);
        countPieceByType(Type.QUEEN, 1);
        countPieceByType(Type.KING, 1);
    }

    private void countPieceByType(Type type, int count) {
        assertThat(board.countPieceByColorAndType(Color.BLACK, type)).isEqualTo(count);
        assertThat(board.countPieceByColorAndType(Color.WHITE, type)).isEqualTo(count);
    }

}
