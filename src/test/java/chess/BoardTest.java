package chess;

import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Pawn white;
    private Pawn black;
    private Board board;

    @BeforeEach
    public void setUP() {
        white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK__REPRESENTATION);
        board = new Board();
    }

    @Test
    public void create() throws Exception {
        check(white, 1, 0);
        check(black, 1, 0);
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnResult());
        assertEquals("PPPPPPPP", board.getBlackPawnResult());
    }

    void check(Pawn pawn, int size, int idx) {
        board.add(pawn);
        assertEquals(size, board.size(pawn));
        assertEquals(pawn, board.findPawn(pawn, idx));
    }
}
