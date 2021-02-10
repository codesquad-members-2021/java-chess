package cooper.chess;

import cooper.chess.piece.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {
    @Test
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn("white");
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(1));

        Pawn black = new Pawn("black");
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(2));
    }

    @Test
    public void testZeroSizeOfBoard() {
        Board board = new Board();
        Pawn pawn = new Pawn();

        assertThrows(IllegalArgumentException.class,
                () -> board.findPawn(0));
    }

    @Test
    public void testOutOfBoardSize() {
        Board board = new Board();

        Pawn white = new Pawn("white");
        board.add(white);

        Pawn black = new Pawn("black");
        board.add(black);

        assertThrows(IndexOutOfBoundsException.class,
                () -> board.findPawn(-1));
        assertThrows(IndexOutOfBoundsException.class,
                () -> board.findPawn(2));
    }
}