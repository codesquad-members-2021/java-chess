package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Piece white;
    private Piece black;
    private Board board;

    @BeforeEach
    public void setUP() {
        white = new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        black = new Piece(Piece.BLACK_COLOR, Piece.BLACK__REPRESENTATION);
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        check(white, 1, 0);
        check(black, 1, 0);
    }

    @Test
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnResult());
        assertEquals("PPPPPPPP", board.getBlackPawnResult());
    }

    @Test
    public void print() {
        assertEquals("........", board.getEmptyResult());
    }

    void check(Piece pawn, int size, int idx) {
        board.add(pawn);
        assertEquals(size, board.size(pawn));
        assertEquals(pawn, board.findPawn(pawn, idx));
    }
}
