package cooper.chess;

import cooper.chess.piece.Color;
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
                () -> assertEquals(1, board.size(Color.WHITE)),
                () -> {
                    assertEquals(white, board.findPawn(0, Color.WHITE));
                    assertEquals(black, board.findPawn(0, Color.BLACK));
                }
        );
    }

    @Test
    public void testZeroSizeOfBoard() {
        Board board = new Board();

        assertThrows(IllegalArgumentException.class,
                () -> board.findPawn(0, Color.WHITE));
    }

    @Test
    public void testOutOfBoardSize() {
        Board board = new Board();

        Pawn white = new Pawn("white");
        board.add(white);

        Pawn black = new Pawn("black");
        board.add(black);

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(-1, Color.WHITE)),
                () -> assertThrows(IllegalArgumentException.class, () -> board.findPawn(3, Color.BLACK))
        );
    }

    @Test
    public void initialize() {
        Board board = new Board();
        board.initialize();
        assertAll(
                () -> assertEquals("PPPPPPPP", board.getPawnsResult(Color.WHITE)),
                () -> assertEquals("pppppppp", board.getPawnsResult(Color.BLACK))
        );
    }

    @Test
    public void print() {
        Board board = new Board();
        board.initialize();
        System.out.println(board.getBoardStatus());
    }
}
