package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("색 없이 Pawn을 생성하면 흰색으로 생성되어야 한다")
    void createPawn() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    void createPawnWithColor() {
        verifyPawn(Color.WHITE, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    void verifyPawn(Color color, final char representation) {
        Pawn pawn = new Pawn(color, representation );
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }
}
