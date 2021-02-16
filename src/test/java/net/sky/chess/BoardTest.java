package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sky.pieces.Color;
import net.sky.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판에 있는 폰의 색깔별 사이즈 확인 테스트")
    void verifySizeOfBoard() throws Exception {
        verifyWhitePawn(1, 0);
        verifyWhitePawn(2, 1);

        verifyBlackPawn(1, 0);
        verifyBlackPawn(2, 1);
    }

    void verifyWhitePawn(int size, int idx) {
        Color color = Color.WHITE;
        Pawn pawn = new Pawn(color);
        board.addWhitePawn(pawn);
        assertAll(
            () -> assertThat(board.getWhitePawnsSize()).isEqualTo(size),
            () -> assertThat(board.findWhitePawn(idx)).isEqualTo(pawn)
        );
    }

    void verifyBlackPawn(int size, int idx) {
        Color color = Color.BLACK;
        Pawn pawn = new Pawn(color);
        board.addBlackPawn(pawn);
        assertAll(
            () -> assertThat(board.getBlackPawnsSize()).isEqualTo(size),
            () -> assertThat(board.findBlackPawn(idx)).isEqualTo(pawn)
        );
    }

    @Test
    @DisplayName("보드 초기화 테스트")
    void initializeBoard() throws Exception {
        board.initialize();
        assertAll(
            () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
            () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }

    @Test
    void printBoard() {
        board.initialize();
        board.print();
    }

}
