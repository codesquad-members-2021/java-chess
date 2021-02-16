package net.honux.chess;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

import net.honux.chess.pieces.Pawn;

class BoardTest {
    private Board board = new Board();

    @Test
    public void create() throws Exception {

        verifyBoard(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION, 0);
        verifyBoard(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION, 1);
    }

    private void verifyBoard(String color, char representation, int index) {

        Pawn pawnColor = new Pawn(color, representation);
        board.add(pawnColor);
        assertThat(board.size()).isEqualTo(index + 1);
        assertThat(board.findPawn(index)).isEqualTo(pawnColor);
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getWhitePawnsResult()).isEqualTo("PPPPPPPP");
    }

}
