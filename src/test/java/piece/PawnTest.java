package piece;

import static org.junit.jupiter.api.Assertions.*;

import pieces.Pawn;
import org.junit.jupiter.api.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.Color.WHITE, 'p');
        verifyPawn(Pawn.Color.BLACK, 'P');
    }

    public void verifyPawn(Pawn.Color color, Character character){
        Pawn pawn = new Pawn(color, character);
        assertEquals(color, pawn.getColor());
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.Color.WHITE, pawn.getColor());
    }
}