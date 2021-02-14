package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PawnTest {
    @Test
    void create() {
        assertAll(
                () -> assertThat(Pawn.create("white").getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(Pawn.create("black").getColor()).isEqualTo(Color.BLACK)
        );
    }
}
