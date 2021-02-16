package cooper.chess.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PawnTest {

    @Test
    public void create_defaultConstructor() {
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE.getColorName(), pawn.getColor().getColorName());
        assertEquals(Color.WHITE.getRepresentation(), pawn.getRepresentation());
    }

    @Test
    public void create() {
        verifyPawn(Color.WHITE.getColorName(), Color.WHITE.getRepresentation());
        verifyPawn(Color.BLACK.getColorName(), Color.BLACK.getRepresentation());
    }

    @Test()
    public void checkOtherColorName() {
        assertThrows(IllegalArgumentException.class, () -> new Pawn("green"));
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color);

        assertAll(
                () -> assertEquals(color, pawn.getColor().getColorName()),
                () -> assertEquals(representation, pawn.getRepresentation())
        );
    }
}
