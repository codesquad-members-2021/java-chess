package net.isaac.chess;

import org.junit.jupiter.api.BeforeEach;
import net.isaac.pieces.Pawn;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        board.add(white, 0, 0);
        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black, 0, 1);

        assertAll(
                ()->assertThat(board.findPawn(0,0)).isEqualTo(white),
                ()->assertThat(board.findPawn(0,1)).isEqualTo(black),
                ()->assertThat(board.findPawn(0,2)).isEqualTo(null),
                ()->assertThat(board.findPawn(10,10)).isEqualTo(null)
        );
    }
}
