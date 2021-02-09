
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    @DisplayName("하얀색과 검은색 폰이 생성되어야한다.")
    public void create() {
        verifyPawn(Pawn.Color.WHITE);
        verifyPawn(Pawn.Color.BLACK);
    }

    private void verifyPawn(Pawn.Color color) {
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }

}
