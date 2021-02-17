package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    void create() {
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
    public void initialize() {
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
        Piece piece = new Piece(color);
        board.addWhite(piece);
        return piece;
    }

    Piece addBlackPawn(String color) {
        Piece piece = new Piece(color);
        board.addBlack(piece);
        return piece;
    }
}