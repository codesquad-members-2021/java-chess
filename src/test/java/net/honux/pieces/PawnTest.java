package net.honux.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    void createWhiteAndBlackPawns() {
        assertAll(
                () -> verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION),
                () -> verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
    }

    @Test
    @DisplayName("기본 생성자로 폰을 생성할 때, 흰색 폰이 생성되어야 한다")
    void createWithDefaultPawn() {
        Pawn pawn = new Pawn();
        assertThat(Pawn.WHITE_COLOR).isEqualTo(pawn.getColor());
        assertThat(Pawn.WHITE_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }

    @Test
    @DisplayName("다른 색 폰이 생성되면 안된다")
    void createRedPawn() {
        assertThatThrownBy(() -> new Pawn("red"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(representation).isEqualTo(pawn.getRepresentation());
    }

}
