package net.coco.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class pawnTest {

    @Test
    @DisplayName("기본 생성자 테스트")
    void create_defaultConstructor() {
        Piece piece = new Piece();
        Assertions.assertAll(
                () -> assertThat(PawnEnum.WHITE).isEqualTo(piece.getColor()),
                () -> assertThat(PawnEnum.WHITE.getRepresentation()).isEqualTo(piece.getRepresentation())
        );

    }

    @Test
    @DisplayName("폰이 요구대로 생성되는지 테스트")
    void pawnColorTest() {
        verifyPawn(PawnEnum.WHITE);
        verifyPawn(PawnEnum.BLACK);
    }

    void verifyPawn(PawnEnum pawnEnum) {
        Piece piece = new Piece(pawnEnum);
        Assertions.assertAll(
                () -> assertThat(pawnEnum).isEqualTo(piece.getColor()),
                () -> assertThat(pawnEnum.getRepresentation()).isEqualTo(piece.getRepresentation())
        );
    }

}
