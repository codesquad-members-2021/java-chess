package cooper.chess;

import cooper.chess.piece.Color;
import cooper.chess.piece.Pawn;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn(Color.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(1));

        Pawn black = new Pawn(Color.BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroSizeOfBoard() {
        Board board = new Board();
        Pawn pawn = new Pawn();

        assertEquals(pawn, board.findPawn(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBoardSize() {
        Board board = new Board();

        Pawn white = new Pawn(Color.WHITE);
        board.add(white);

        Pawn black = new Pawn(Color.BLACK);
        board.add(black);

        assertEquals(white, board.findPawn(-1));
        assertEquals(black, board.findPawn(2));
    }
}