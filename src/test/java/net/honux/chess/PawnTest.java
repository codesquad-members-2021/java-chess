package net.honux.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    void create() {
        verifyPawn("white");
        verifyPawn("black");
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}
