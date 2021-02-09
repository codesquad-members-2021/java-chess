package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {
    @Test
    void create() {
        assertThat(Pawn.create("white").getColor()).isEqualTo(Color.WHITE);
        assertThat(Pawn.create("black").getColor()).isEqualTo(Color.BLACK);
    }
}
