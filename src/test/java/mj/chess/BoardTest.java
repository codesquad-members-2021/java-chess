package mj.chess;

import mj.chess.pieces.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("오직 pawns로 구성된 체스판을 생성")
    void createBoardOnlyWithPawns() {
        final int numOfAllPieces = 16;
        board.initialize();

        assertAll(
                () -> verifyCounting(board, numOfAllPieces),
                () -> verifyRepresentationOfPawns(board)
        );
    }

    private void verifyCounting(Board board, int maxNum) {
        assertThat(board.countPieces()).isEqualTo(maxNum);
    }

    private void verifyRepresentationOfPawns(Board board) {
        StringBuilder blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                new StringBuilder()
                        .append(String.valueOf(blankRank))
                        .append(appendNewLine("PPPPPPPP"))
                        .append(blankRank).append(blankRank)
                        .append(blankRank).append(blankRank)
                        .append(appendNewLine("pppppppp"))
                        .append(blankRank)
                        .toString()
        );
    }

    @Test
    @DisplayName("폰의 생성 개수를 확인")
    void checkInitPawns() {
        verifySizeOfPawns();
    }

    private void verifySizeOfPawns(){
        board.initialize();
        assertThat(board.countPawns()).isEqualTo(16);
    }

    @Test
    @DisplayName("Board class에 ")
    void createBoard() {
        final int numOfAllPieces = 32;
        board.initialize();

        assertAll(
                () -> verifyCounting(board, numOfAllPieces),
                () -> verifyRepresentationOfPawns(board)
        );
    }

    private void verifyRepresentationOfPieces(Board board) {
        StringBuilder blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                new StringBuilder()
                        .append(appendNewLine("RNBQKBNR"))
                        .append(appendNewLine("PPPPPPPP"))
                        .append(blankRank).append(blankRank).append(blankRank).append(blankRank)
                        .append(appendNewLine("pppppppp"))
                        .append(appendNewLine("rnbqkbnr"))
                        .toString()
        );
    }
}
