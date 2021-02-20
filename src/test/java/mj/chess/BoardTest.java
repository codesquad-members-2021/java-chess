package mj.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static mj.chess.utils.StringUtil.appendNewLine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판 생성에 따라 모든 기물의 개수 및 초기 출력상태 확인")
    void createBoard() {
        final int numOfAllPieces = 32;
        board.initialize();

        assertAll(
                () -> verifyCounting(board, numOfAllPieces),
                () -> verifyRepresentationOfPieces(board)
        );
    }

    private void verifyCounting(Board board, int maxNum) {
        assertThat(board.countPieces()).isEqualTo(maxNum);
    }

    private void verifyRepresentationOfPieces(Board board) {
        String blankRank = appendNewLine("........");
        String initialLocationOfPieces = new StringBuilder()
                .append(appendNewLine("RNBQKBNR"))
                .append(appendNewLine("PPPPPPPP"))
                .append(blankRank).append(blankRank).append(blankRank).append(blankRank)
                .append(appendNewLine("pppppppp"))
                .append(appendNewLine("rnbqkbnr"))
                .toString();

        assertThat(board.getLocationOfPieces()).isEqualTo(initialLocationOfPieces);
    }
}
