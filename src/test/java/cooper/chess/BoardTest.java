package cooper.chess;

import cooper.chess.piece.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn("white");
        board.add(white);

        Pawn black = new Pawn("black");
        board.add(black);

        assertAll(
                () -> assertEquals(2, board.size()),
                () -> {
                    assertEquals(white, board.findPawn(1));
                    assertEquals(black, board.findPawn(2));
                }
        );
    }

    @Test
    public void testZeroSizeOfBoard() {
        Board board = new Board();

        assertThrows(IndexOutOfBoundsException.class,
                () -> board.findPawn(0));
    }

    @Test
    public void testOutOfBoardSize() {
        Board board = new Board();

        Pawn white = new Pawn("white");
        board.add(white);

        Pawn black = new Pawn("black");
        board.add(black);

        assertAll(
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.findPawn(-1)),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.findPawn(3))
        );
    }
}