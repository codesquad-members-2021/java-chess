package net.Dong;

import net.Dong.chess.Pawn;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import net.Dong.chess.Pawn.Color.*;
import net.Dong.chess.Pawn.*;
class PawnTest {

    @Test
    public void  create() throws Exception{
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getSymbol());
    }

    @Test
    public void create_Pawn() {

        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);

    }

    void verifyPawn(Color c) {
        Pawn p = new Pawn(c);
        assertEquals(c, p.getColor(),"fail");
    }

}