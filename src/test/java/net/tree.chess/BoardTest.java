package net.tree.chess;

import net.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @DisplayName("보드 생성하기(모든 피스 포함)")
    @Test
    void createBoard() {
        board.initialize();
        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard())
                .isEqualTo(
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));

        System.out.println(board.showBoard());
    }

    //개행 추가시키는 메소드
    private String appendNewLine(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(StringUtils.NEWLINE);
        return sb.toString();
    }


}
