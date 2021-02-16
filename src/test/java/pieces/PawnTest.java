package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PawnTest {

    @Test
    @DisplayName("Verify default constructor")
    void create_default() throws Exception {
        Pawn pawn = new Pawn();
        assertAll(
                () -> assertThat(Piece.WHITE_COLOR).isEqualTo(pawn.getColor()),
                () -> assertThat(Pawn.WHITE_REPRESENTATION).isEqualTo(pawn.getRepresentation())
        );
    }

    @Test
    @DisplayName("Verify pawns")
    void create() {
        assertAll("color",
                () -> verifyPawnColor(Piece.WHITE_COLOR),
                () -> verifyPawnColor(Piece.BLACK_COLOR),
                () -> verifyPawnRepresentation(Piece.WHITE_COLOR, Pawn.WHITE_REPRESENTATION),
                () -> verifyPawnRepresentation(Piece.BLACK_COLOR, Pawn.BLACK_REPRESENTATION)
        );
    }

    void verifyPawnRepresentation(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

    void verifyPawnColor(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}