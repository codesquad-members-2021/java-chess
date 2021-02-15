package net.sky.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sky.pieces.Pawn.Color;
import net.sky.pieces.Pawn.Representation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {


    @Test
    @DisplayName("폰 색깔 및 색깔별 출력방식 확인 테스트")
    void verifyColorOfPawn() {
        verifyPawn(Color.WHITE, Representation.p);
        verifyPawn(Color.BLACK, Representation.P);
    }

    void verifyPawn(final Color color, final Representation representation) {
        Pawn pawn = new Pawn(color, representation);
        assertAll(
            () -> assertThat(pawn.getColor()).isEqualTo(color),
            () -> assertThat(pawn.getRepresentation()).isEqualTo(representation)
        );

    }

    @Test
    @DisplayName("기본 생성자 폰 색깔 및 색깔별 출력방식 확인 테스트")
    void verifyColorOfPawn_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        verifyPawn(pawn.getColor(), pawn.getRepresentation());
    }

}
