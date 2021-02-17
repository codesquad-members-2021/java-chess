package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
        assertEquals(Color.WHITE.getRepresentation(), pawn.getColor().getRepresentation());
    }

    @Test
    public void create() {
        verifyPawn(Color.WHITE, Color.WHITE.getRepresentation());
        verifyPawn(Color.BLACK, Color.BLACK.getRepresentation());
    }

    void verifyPawn(final Color color, final char representation) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getColor().getRepresentation());
    }
}