package pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("색 없이 Pawn을 생성하면 흰색으로 생성되어야 한다")
    public void createPawn() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    @DisplayName("흰색, 검은색 폰이 생성되어야 한다")
    public void createPawnWithColor() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);
    }

    public void verifyPawn(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
