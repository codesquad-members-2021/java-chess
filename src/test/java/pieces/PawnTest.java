package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("색 없이 Pawn을 생성하면 흰색으로 생성되어야 한다")
    void createPawn() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
        assertThat(pawn.getRepresentation()).isEqualTo(Color.WHITE.getRepresentation());
    }

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    void createPawnWithColor() {
        verifyPawn(Color.WHITE, Color.WHITE.getRepresentation());
        verifyPawn(Color.BLACK, Color.BLACK.getRepresentation());
    }

    void verifyPawn(Color color, final char colorRepresentation) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(colorRepresentation);
    }
}
