package pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("흰색과 검은색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);
    }

    public void verifyPawn(final Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본 생성자 호출 시 흰색 폰이 생성되어야 한다")
    public void createDefaultConstructor() {
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
    }

}
