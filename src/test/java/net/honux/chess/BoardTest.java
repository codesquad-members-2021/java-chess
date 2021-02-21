package net.honux.chess;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

import net.honux.chess.pieces.Piece;

class BoardTest {
    private Board board;

    @Test
    void 보드에_폰이_색깔별로_잘_들어가는지_확인한다() {

        verifyBoard(Piece.WHITE_COLOR, Piece.White.PAWN.representation, 0);
        verifyBoard(Piece.BLACK_COLOR, Piece.Black.PAWN.representation, 0);
    }

    private void verifyBoard(String color, char representation, int index) {

        Piece pawnColor = new Piece(color, representation);
        board.add(pawnColor);
        assertThat(board.size(pawnColor)).isEqualTo(index + 1);
        assertThat(board.findPawn(pawnColor, index)).isEqualTo(pawnColor);
    }

    @Test
    void initialize() {
        board = new Board();
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    void print_잘되는지_확인하자 () {
        board = new Board();
        board.initialize();
        board.print();
    }

}
