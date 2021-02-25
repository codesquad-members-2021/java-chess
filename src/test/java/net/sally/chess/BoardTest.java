package net.sally.chess;

import org.junit.jupiter.api.*;

import static net.sally.util.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.*;

import net.sally.pieces.Piece;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("말들이 정상적으로 등록, 보드가 정상적으로 출력")
    void create() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");

        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP")
                + blankRank + blankRank + blankRank + blankRank
                + appendNewLine("pppppppp")
                + appendNewLine("rnbqkbnr")
        );
    }
}
