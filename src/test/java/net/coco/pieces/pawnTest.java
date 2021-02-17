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
                () -> assertThat(Color.WHITE).isEqualTo(piece.getColor()),
                () -> assertThat(Representation.WHITE_PAWN.getRepresentation()).isEqualTo(piece.getRepresentation())
        );

    }

    @Test
    @DisplayName("폰이 요구대로 생성되는지 테스트")
    void pawnColorTest() {
        verifyPawn(Color.WHITE);
        verifyPawn(Color.BLACK);
    }

    void verifyPawn(Color color) {
        Piece piece = new Piece(color);
        Assertions.assertAll(
                () -> assertThat(color).isEqualTo(piece.getColor()),
                () -> assertThat(color.getRepresentation()).isEqualTo(piece.getRepresentation())
        );
    }

}
