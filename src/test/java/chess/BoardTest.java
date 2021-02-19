package chess;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static utils.StringUtils.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void testInit() {
        board = new Board();
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

        board.initialize();
        assertThat(board.pieceCount()).as("Board Size").isEqualTo(32);
        assertThat(board.showBoard()).as("Board Initial State").isEqualTo(initBoard);
        System.out.println(board.showBoard());
    }

}
