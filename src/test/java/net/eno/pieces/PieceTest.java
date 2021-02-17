package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Color.WHITE, Representation.PAWN);
        verifyPawn(Color.BLACK, Representation.PAWN);
    }

    public void verifyPawn(Color color, Representation representation) {
        Piece pawn = new Piece(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color.toString());
        assertThat(pawn.getRepresentation()).isEqualTo(representation.get(color));
    }

}
