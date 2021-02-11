package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sky.pieces.Pawn;
import net.sky.pieces.Pawn.Color;
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
    @DisplayName("체스판 색깔, 사이즈 확인 테스트")
    void testDetailOfBoard() throws Exception {
        verifyBoard(Color.WHITE, 1, 0);
        verifyBoard(Color.BLACK, 2, 1);
    }

    void verifyBoard(final Color color, int size, int idx) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertAll(
            () -> assertThat(board.size()).isEqualTo(size),
            () -> assertThat(board.findPawn(idx)).isEqualTo(pawn)
        );
    }

}
