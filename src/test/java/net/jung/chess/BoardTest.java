package net.jung.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.jung.chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();

    }


    @Test
    @DisplayName("initialize()는 32개 모든 말을 체스판 위에 올린다.")
    void initializeAddsEveryPiece() {
        int maxNumOfPieces = 32;
        String BLANK_RANK = appendNewLine("********");
        board.initialize();
        assertAll(
                () -> assertThat(board.boardPieceSize()).isEqualTo(maxNumOfPieces),
                () -> assertThat(board.boardLayoutToString()).isEqualTo(
                    appendNewLine("RNBQKBNR")
                    +appendNewLine("PPPPPPPP")
                    +BLANK_RANK
                    +BLANK_RANK
                    +BLANK_RANK
                    +BLANK_RANK
                    +appendNewLine("pppppppp")
                    +appendNewLine("rnbqkbnr"))
        );
    }
}
