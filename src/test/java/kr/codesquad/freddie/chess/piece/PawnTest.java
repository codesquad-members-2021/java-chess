package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    void create() {
        checkColor(Pawn.create("white"), Color.WHITE);
        checkColor(Pawn.create("black"), Color.BLACK);
    }

    private void checkColor(Pawn pawn, Color expected) {
        assertThat(pawn.getColor())
                .isEqualTo(expected);
    }
}