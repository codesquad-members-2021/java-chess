package net.coco.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class pawnTest {

    @Test
    @DisplayName("기본 생성자 테스트")
    void create_defaultConstructor() {
        Pawn pawn = new Pawn();
        Assertions.assertAll(
                () -> assertThat(PawnEnum.WHITE_COLOR).isEqualTo(pawn.getColor()),
                () -> assertThat(PawnEnum.WHITE_COLOR.representation).isEqualTo(pawn.getRepresentation())
        );

    }

    @Test
    @DisplayName("폰이 요구대로 생성되는지 테스트")
    void pawnColorTest() {
        verifyPawn(PawnEnum.WHITE_COLOR);
        verifyPawn(PawnEnum.BLACK_COLOR);
    }

    void verifyPawn(PawnEnum pawnEnum) {
        Pawn pawn = new Pawn(pawnEnum);
        Assertions.assertAll(
                () -> assertThat(pawnEnum).isEqualTo(pawn.getColor()),
                () -> assertThat(pawnEnum.representation).isEqualTo(pawn.getRepresentation())
        );
    }

}
