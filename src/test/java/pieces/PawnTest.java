package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn;

public class PawnTest {
    @Test
    @DisplayName("흰색, 검은색 폰 생성")
    void create() {
        verifyPawn(Pawn.WHITE);
        verifyPawn(Pawn.BLACK);
    }

    @Test
    @DisplayName("색이 없는 폰 생성")
    public void createDefaultConstructor() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColor());
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
