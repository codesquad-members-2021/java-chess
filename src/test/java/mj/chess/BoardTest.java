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
    @DisplayName("폰의 생성 개수 확인")
    void initPawns() {
        verifySizeOfPawns();
    }

    private void verifySizeOfPawns(){
        final int maxSizeOfPawns = 16;
        board.initialize();
        assertThat(board.countPawns()).isEqualTo(maxSizeOfPawns);
    }

    @Test
    @DisplayName("체스판 생성에 따라 폰의 개수 및 초기 출력상태 확인")
    void createBoardOnlyWithPawns() {
        final int numOfAllPawns = 16;
        board.initialize();

        assertAll(
                () -> verifyCountingOnlyPawns(board, numOfAllPawns),
                () -> verifyRepresentationOfPawns(board)
        );
    }

    private void verifyCountingOnlyPawns(Board board, int maxNum) {
        assertThat(board.countPawns()).isEqualTo(maxNum);
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
