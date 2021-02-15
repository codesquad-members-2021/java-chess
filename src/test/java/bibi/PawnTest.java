package bibi;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("흰색, 검은색 폰 생성")
    void create() {
        String white = "white";
        String black = "black";
        verifyPawn(white);
        verifyPawn(black);
    }

    @Test
    @DisplayName("색이 없는 폰 생성")
    public void createDefaultConstructor() {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
