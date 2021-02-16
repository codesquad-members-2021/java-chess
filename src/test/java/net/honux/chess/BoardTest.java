package net.honux.chess;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

import net.honux.chess.pieces.Pawn;

class BoardTest {
    private Board board = new Board();

    @Test
    void 보드에_폰이_색깔별로_잘_들어가는지_확인한다() throws Exception {

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
    void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    void print_잘되는지_확인하자 () {
        Board board = new Board();
        board.print();
    }

}
