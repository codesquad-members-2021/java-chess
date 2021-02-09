package chess;

import org.junit.jupiter.api.*;
import pieces.Pawn;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

class BoardTest {
    @Test
    public void create() {
        Board board = new Board();
        Pawn whitePawn = new Pawn(Color.WHITE);
        board.add(whitePawn);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(whitePawn);

        Pawn blackPawn = new Pawn(Color.BLACK);
        board.add(blackPawn);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(blackPawn);
    }
}