package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("Verify default constructor")
    void createDefault() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Piece.WHITE_COLOR, pawn.getColor());
    }

    @Test
    @DisplayName("Verify pawns")
    void create() {
        verifyPawn(Piece.WHITE_COLOR);
        verifyPawn(Piece.BLACK_COLOR);
    }

    void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}