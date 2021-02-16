package net.isaac.chess;

import org.junit.jupiter.api.BeforeEach;
import net.isaac.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp(){
        board = new Board();
    }

    @Test
    @DisplayName("Board의 Pawn 등록 테스트")
    void pawnAddTest() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }
}
