package net.Dong;

import net.Dong.chess.Pawn;
import net.Dong.chess.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    @DisplayName("Color Test")
    void PawnCreate() {

        verifyPawnColor(Color.WHITE);
        verifyPawnColor(Color.BLACK);
    @Test
    public void  create() throws Exception{
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE, pawn.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getSymbol());
    }


    }

    void verifyPawnColor(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}

