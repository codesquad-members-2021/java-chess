package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("지정한 색상의 폰이 생성되었는지 검증한다.")
    public void create() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);
        verifyPawn();
    }

    public void verifyPawn() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    public void verifyPawn(final Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
