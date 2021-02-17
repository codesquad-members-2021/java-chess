package net.woody.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("흰색 폰과 검은색 폰이 생성되어야 한다")
    void createWhiteAndBlackPawns() {
        assertAll(
                () -> verifyPawn(Color.WHITE.colorName()),
                () -> verifyPawn(Color.BLACK.colorName())
        );
    }

    @Test
    @DisplayName("기본 생성자로 폰을 생성할 때, 흰색 폰이 생성되어야 한다")
    void createWithDefaultPawn() {
        Pawn pawn = new Pawn();
        assertThat(Color.WHITE).isEqualTo(pawn.getColor());
        assertThat(Pawn.PAWN_REPRESENTATION).isEqualTo(pawn.getRepresentation());
    }

    @Test
    @DisplayName("다른 색 폰이 생성되면 안된다")
    void createRedPawn() {
        assertThatThrownBy(() -> new Pawn("red"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColorName()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(pawn.getRepresentation());
    }

}
