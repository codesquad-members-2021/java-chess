package net.honux.chess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import net.honux.chess.pieces.Pawn;

class BoardTest {
    private Board board = new Board();

    @Test
    public void create() throws Exception {

        verifyBoard(Pawn.WHITE_COLOR, 0);
        verifyBoard(Pawn.BLACK_COLOR, 1);
    }

    private void verifyBoard(String color, int index) {

        Pawn pawnColor = new Pawn(color);
        board.add(pawnColor);
        assertEquals(index + 1, board.size());
        assertEquals(pawnColor, board.findPawn(index));
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getWhitePawnsResult()).isEqualTo("PPPPPPPP");
    }

}
