
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest{

    @Test
    public void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertEquals(color, pawn.getColor());
    }

}