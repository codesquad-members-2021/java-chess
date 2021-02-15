package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                () -> verifyPawn(Piece.WHITE_COLOR, Pawn.WHITE_REPRESENTATION),
                () -> verifyPawn(Piece.BLACK_COLOR, Pawn.BLACK_REPRESENTATION)
        );
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}