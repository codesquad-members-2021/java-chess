package net.Dong;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class PawnTest {



    @Test
    @DisplayName("TSET >> START ")
    public void create() {
        verifyPawn("white");
        verifyPawn("black");

    }

    void verifyPawn(final String color) {
        Pawn p = new Pawn(color);
        assertEquals(color, p.getColor(),"fail");
    }

}