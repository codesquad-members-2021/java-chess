package chess;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import pieces.Pawn;
import pieces.Piece;

public class BoardTest {
    private static Board board;

    @BeforeEach
    @DisplayName("Create board")
    void create_board() {
        board = new Board();
    }

    @Test
    @DisplayName("Create pawns")
    void create() throws Exception {
        Piece white = add(Piece.WHITE_COLOR);
        verifySize(1);
        verifyFindPawn(white, 0);

        Piece black = add(Piece.BLACK_COLOR);
        verifySize(2);
        verifyFindPawn(black, 0);
    }

    @Test
    @DisplayName("Init board")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }

    void verifySize(int expectedSize) {
        assertEquals(expectedSize, board.size());
    }

    void verifyFindPawn(Piece piece, int index) {
        if (piece.getColor().equals(Piece.WHITE_COLOR)) {
            assertEquals(piece, board.findWhite(index));
        } else {
            assertEquals(piece, board.findBlack(index));
        }

    }

    Piece add(String color) {
        Pawn pawn = new Pawn(color);

        if (color.equals(Piece.WHITE_COLOR)) {
            board.addWhite(pawn);
        } else {
            board.addBlack(pawn);
        }

        return pawn;
    }
}