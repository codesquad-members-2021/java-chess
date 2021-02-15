package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sky.pieces.Pawn;
import net.sky.pieces.Pawn.Color;
import net.sky.pieces.Pawn.Representation;
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
    @DisplayName("체스판 사이즈 및 보드에 폰이 제대로 들어갔는지 확인 테스트")
    void testDetailOfBoard() throws Exception {
        verifyBoard(Color.WHITE, 1, 0, Representation.p);
        verifyBoard(Color.BLACK, 2, 1, Representation.P);
    }

    void verifyBoard(final Color color, int size, int idx, final Representation representation) {
        Pawn pawn = new Pawn(color, representation);
        board.add(pawn);
        assertAll(
            () -> assertThat(board.size()).isEqualTo(size),
            () -> assertThat(board.findPawn(idx)).isEqualTo(pawn)
        );
    }

    @Test
    @DisplayName("보드 초기화 확인 테스트")
    void boardInitialize() throws Exception {
        board.initialize();
        assertAll(
            () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
            () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }

}
