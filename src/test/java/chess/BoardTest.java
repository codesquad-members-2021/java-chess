package chess;

import org.testng.annotations.Test;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import pieces.Pawn;

public class BoardTest {
    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }
}