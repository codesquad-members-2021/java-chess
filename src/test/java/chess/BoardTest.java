package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        board.initialize();
        assertAll(
                ()->assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult()),
                ()->assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult())
        );
    }

    void verifySize(int expectedSize) {
        assertThat(expectedSize).isEqualTo(board.size());
    }

    void verifyFindPawn(Piece piece, int index) {
        if (piece.getColor().equals(Piece.WHITE_COLOR)) {
            assertThat(piece).isEqualTo(board.findWhite(index));
        } else {
            assertThat(piece).isEqualTo(board.findBlack(index));
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