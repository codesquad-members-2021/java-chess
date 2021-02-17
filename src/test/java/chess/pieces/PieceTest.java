package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    public void create_기본생성자() throws Exception {
        Piece pawn = new Piece();
        assertEquals(Color.WHITE, pawn.getColor());
        assertEquals(Color.WHITE.getRepresentation(), pawn.getColor().getRepresentation());
    }

    @Test
    public void create() {
        verifyPawn(Color.WHITE, Color.WHITE.getRepresentation());
        verifyPawn(Color.BLACK, Color.BLACK.getRepresentation());
    }

    void verifyPawn(final Color color, final char representation) {
        Piece pawn = new Piece(color);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getColor().getRepresentation());
    }
}