package chess;

import chess.pieces.Piece;
import chess.pieces.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Piece white;
    private Piece black;
    private Board board;

    @BeforeEach
    public void setUP() {
        white = new Piece(Color.WHITE);
        black = new Piece(Color.BLACK);
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
