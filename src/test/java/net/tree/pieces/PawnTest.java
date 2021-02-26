package net.tree.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


 class PawnTest {

    @DisplayName("기본생성자로 생성한 pawn")
    @Test
    void createPawnByDefaultConstructor() {
        Pawn pawn = new Pawn();
        Assertions.assertAll(
                () -> assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR),
                () -> assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION)
        );
    }

    @DisplayName("color, representation 매개변수로 받아서 생성한 pawn")
    @Test
    void createPawn() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);

    }

    void verifyPawn(final String color, final  char representation) {
        Pawn pawn = new Pawn(color, representation);

        Assertions.assertAll(
            () -> assertThat(pawn.getColor()).isEqualTo(color),
            () -> assertThat(pawn.getRepresentation()).isEqualTo(representation)
        );

    }

}
