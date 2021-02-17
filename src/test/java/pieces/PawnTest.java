package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PawnTest {

    @Test
    @DisplayName("Verify default constructor")
    void create_default() {
        Piece piece = new Piece();
        assertAll(
                () -> assertThat(Piece.WHITE_COLOR).isEqualTo(piece.getColor()),
                () -> assertThat(Piece.WHITE_REPRESENTATION).isEqualTo(piece.getRepresentation())
        );
    }

    @Test
    @DisplayName("Verify pawns")
    void create() {
        assertAll("color",
                () -> verifyPawnColor(Piece.WHITE_COLOR),
                () -> verifyPawnColor(Piece.BLACK_COLOR),
                () -> verifyPawnRepresentation(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION),
                () -> verifyPawnRepresentation(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION)
        );
    }

    void verifyPawnRepresentation(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    void verifyPawnColor(final String color) {
        Piece piece = new Piece(color);
        assertThat(piece.getColor()).isEqualTo(color);
    }
}