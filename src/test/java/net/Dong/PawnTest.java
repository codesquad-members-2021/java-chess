package net.Dong;

import net.Dong.chess.Pawn;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import net.Dong.chess.Pawn.Color.*;
import net.Dong.chess.Pawn.*;
class PawnTest {



    @Test
    @DisplayName("TSET >> START ")
    public void create() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BALCK);

    }

    void verifyPawn(Color c) {
        Pawn p = new Pawn(c);
        assertEquals(c, p.getColor(),"fail");
    }

}