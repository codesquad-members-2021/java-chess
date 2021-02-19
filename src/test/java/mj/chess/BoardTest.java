package mj.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static mj.chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Board class에 Pawn class 추가 및 인덱스로 탐색")
    void createBoard() {
        final int numOfAllPieces = 32;
        board.initialize();

        assertAll(
                () -> verifyCounting(board, numOfAllPieces),
                () -> verifyRepresentationOfPawns(board)
        );
    }

    private void verifyCounting(Board board, int maxNum){
        assertThat(board.pieceCount()).isEqualTo(maxNum);
    }

    private void verifyRepresentationOfPawns(Board board) {
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
