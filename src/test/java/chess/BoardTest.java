package chess;

import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void create() {
        Board board = new Board();

        Pawn white = new Pawn();
        board.add(white);
        assertEquals(1, board.size());

        Pawn black = new Pawn(Pawn.Color.BLACK);
        board.add(black);
        assertEquals(2, board.size());
    }

    @Test
    void initialize() throws Exception {
        Board board = new Board();
        board.initialize();

        String testp = "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " " + "p" + " ";
        String testP = "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " " + "P" + " ";

        assertEquals(testp, board.getWhitePawnResult());
        assertEquals(testP, board.getBlackPawnResult());
    }

}