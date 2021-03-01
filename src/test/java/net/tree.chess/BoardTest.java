package net.tree.chess;

import net.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    Board board;

    @BeforeEach
    void makeNewBoard() {
        board = new Board();
    }

    @DisplayName("모든 피스가 포함된 보드 생성하기")
    @Test
    void createBoardWithAllPieces() {
        board.initializeAllPieces();
        String blankRank = appendNewLine("........");

        assertThat(board.countAllPieces()).isEqualTo(Board.TOTAL_PIECES_SIZE);
        assertThat(board.createInitializedBoard())
                .isEqualTo(
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));

        System.out.println(board.createInitializedBoard());
    }

    private String appendNewLine(String text) {
        return text + StringUtils.NEWLINE;
    }



}

