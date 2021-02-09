package net.Dong;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static net.Dong.Pawn.Color.*;
import static net.Dong.Pawn.*;
class PawnTest {



    @Test
    @DisplayName("TSET >> START ")
    public void create() {
        verifyPawn(WHITE);
        verifyPawn(BALCK);

    }

    void verifyPawn(Color c) {
        Pawn p = new Pawn(c);
        assertEquals(c, p.getColor(),"fail");
    }

}