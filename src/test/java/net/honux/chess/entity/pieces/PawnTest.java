package net.honux.chess.entity.pieces;

import net.honux.chess.attribute.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다.")
    void createWhitePawn() {
        Pawn pawn = new Pawn(Color.WHITE);
        Assertions.assertAll(
                () -> assertThat(pawn.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(pawn.getRepresentation()).isEqualTo('p')
        );

    }

    @Test
    @DisplayName("Pawn 을 기본 생성자로 생성할시 하얀색으로 생성되는지 확인한다.")
    void PawnDefaultColorWhiteTest() {
        Pawn pawn = new Pawn();
        assertThat(Color.WHITE).isEqualTo(pawn.getColor());
    }

    @Test
    @DisplayName("유효하지 않은 Representation 값을 넣어도 정상적으로 주입되는지 확인한다.")
    void validatePawnRepresentation() {
        Pawn pawn = new Pawn(Color.WHITE, Pawn.BLACK_REPRESENTATION);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }

}
