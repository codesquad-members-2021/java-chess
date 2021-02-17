package chess;

import org.junit.Before;
import org.junit.jupiter.api.*;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board;

    @Before
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("초기 체스판 생성")
    void create_initial_chess_board() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
        );
    }
}
