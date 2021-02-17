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
        Piece white = addWhitePawn(Piece.WHITE_COLOR);
        assertAll(
                () -> verifySize(1),
                () -> verifyFindWhitePawn(white, 0)
        );

        Piece black = addBlackPawn(Piece.BLACK_COLOR);
        assertAll(
                () -> verifySize(2),
                () -> verifyFindBlackPawn(black, 0)
        );
    }

    @Test
    @DisplayName("Init board")
    public void initialize() throws Exception {
        board.initialize();
        assertAll(
                () -> assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult()),
                () -> assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult())
        );
    }

    void verifySize(int expectedSize) {
        assertThat(expectedSize).isEqualTo(board.size());
    }

    void verifyFindWhitePawn(Piece piece, int index) {
        assertThat(piece).isEqualTo(board.findWhite(index));
    }

    void verifyFindBlackPawn(Piece piece, int index) {
        assertThat(piece).isEqualTo(board.findBlack(index));
    }

    Piece addWhitePawn(String color) {
        Pawn pawn = new Pawn(color);
        board.addWhite(pawn);
        return pawn;
    }

    Piece addBlackPawn(String color) {
        Pawn pawn = new Pawn(color);
        board.addBlack(pawn);
        return pawn;
    }
}