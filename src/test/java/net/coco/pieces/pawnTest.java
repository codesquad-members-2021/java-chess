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

}
