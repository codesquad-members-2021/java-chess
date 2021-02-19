package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {
    private Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판의 초기화가 정상적으로 이루어졌는지 확인한다.")
    void printBoard() {
        board.initialize();
        String blankRank = StringUtils.addNewLine("........");

        assertThat(32).isEqualTo(board.totalPiecesCount());
        assertThat(StringUtils.addNewLine("RNBQKBNR") +
                StringUtils.addNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                StringUtils.addNewLine("pppppppp") +
                StringUtils.addNewLine("rnbqkbnr"))
                .isEqualTo(board.showBoard());
    }
}
