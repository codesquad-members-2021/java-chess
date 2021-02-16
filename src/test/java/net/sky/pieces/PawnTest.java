package net.sky.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {


    @Test
    @DisplayName("폰 색깔 및 색깔별 출력방식 확인 테스트")
    void verifyColorTypeByPawn() {
        verifyPawn(Color.WHITE, 'p');
        verifyPawn(Color.BLACK, 'P');
    }

    void verifyPawn(final Color color, final char representation) {
        Pawn pawn = new Pawn(color);
        assertAll(
            () -> assertThat(pawn.getColor()).isEqualTo(color),
            () -> assertThat(pawn.getRepresentation()).isEqualTo(representation)
        );

    }

    @Test
    @DisplayName("기본 생성자 폰 색깔 및 색깔별 출력방식 확인 테스트")
    void verifyColorTypeByPawn_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        verifyPawn(pawn.getColor(), pawn.getRepresentation());
    }

}
