package net.Dong;

import net.Dong.chess.Pawn;
import net.Dong.chess.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    @DisplayName("Color Test")
    void create() {

        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);

    }

    void verifyPawn(Color color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.color()).isEqualTo(color);
    }
}

