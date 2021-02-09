package chess;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import pieces.Pawn;
import pieces.Piece;

public class BoardTest {
    private static Board board;

    @BeforeAll
    @DisplayName("init board")
    static void init() {
        board = new Board();
    }

    @Test
    @DisplayName("create pawns")
    void create() throws Exception {
        Piece white = add(Piece.WHITE_COLOR);
        verifySize(1);
        verifyFindPawn(white, 0);

        Piece black = add(Piece.BLACK_COLOR);
        verifySize(2);
        verifyFindPawn(black, 1);
    }

    void verifySize(int expectedSize) {
        assertEquals(expectedSize, board.size());
    }

    void verifyFindPawn(Piece piece, int index) {
        assertEquals(piece, board.findPawn(index));
    }

    Piece add(String color) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        return pawn;
    }
}