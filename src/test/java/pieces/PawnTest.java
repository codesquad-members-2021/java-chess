package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("지정한 색상의 폰이 생성되었는지 검증한다.")
    public void create() {
        final String white = "white";
        final String black = "black";
        verifyPawn(white);
        verifyPawn(black);
    }

    public void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
