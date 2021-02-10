package Chess;

import static org.junit.Assert.*;
import org.junit.Test;


public class BoardTest {
    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn whitePawn = new Pawn(Pawn.WHITE);
        board.add(whitePawn);
        assertEquals(1, board.size());
        assertEquals(whitePawn, board.findPawn(0));

        Pawn blackPawn = new Pawn(Pawn.BLACK);
        board.add(blackPawn);
        assertEquals(2, board.size());
        assertEquals(blackPawn, board.findPawn(1));
    }
}