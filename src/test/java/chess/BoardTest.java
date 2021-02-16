package chess;

import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn();
        board.add(white);
        assertEquals(1, board.size());

        Pawn black = new Pawn(Pawn.Color.BLACK);
        board.add(black);
        assertEquals(2, board.size());
    }

    @Test
    public void initialize() throws Exception{
        Board board = new Board();
        board.initialize();
        assertEquals("p p p p p p p p", board.getWhitePawnResult());
        assertEquals("P P P P P P P P", board.getBlackPawnResult());
    }

}