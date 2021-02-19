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
                () -> verifyPawn(Color.WHITE.toString()),
                () -> verifyPawn(Color.BLACK.toString())
        );
    }

    @Test
    @DisplayName("기본 생성자로 폰을 생성할 때, 흰색 폰이 생성되어야 한다")
    void createWithDefaultPawn() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.PAWN_REPRESENTATION);
    }

    @Test
    @DisplayName("다른 색 폰이 생성되면 안된다")
    void createRedPawn() {
        assertThatThrownBy(() -> new Pawn("red"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void verifyPawn(final String color) {
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor().toString()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(Color.value(color).representation('p'));
    }

}
