package net.Dong;

import net.Dong.chess.Pawn;
import net.Dong.chess.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    @DisplayName("Pawn Color Test")
    void PawnColorTest() {
        verifyPawnColor(Color.WHITE);
        verifyPawnColor(Color.BLACK);
    }

    void verifyPawnColor(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
