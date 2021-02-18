package net.sky.chess;

import static net.sky.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판 초기화 확인")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(0);
        String blankRank = appendNewLine("........");
        assertThat(appendNewLine("RNBQKBNR")
            + appendNewLine("PPPPPPPP")
            + blankRank + blankRank + blankRank + blankRank
            + appendNewLine("pppppppp")
            + appendNewLine("rnbqkbnr")).isEqualTo(board.showBoard());
    }

}
