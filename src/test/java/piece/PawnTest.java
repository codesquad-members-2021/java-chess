package piece;

import static org.junit.jupiter.api.Assertions.*;

import pieces.Pawn;
import org.junit.jupiter.api.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    public void verifyPawn(String color){
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}