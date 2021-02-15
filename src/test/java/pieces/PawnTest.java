package pieces;

import org.junit.jupiter.api.*;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PawnTest {
    @Test
    @DisplayName("기본 생성자에서 흰색 폰이 생성되었는지 검증")
    void create_기본생성자() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    @DisplayName("색상과 출력 양식에 알맞게 폰이 생성되었는지 검증")
    void create() {
        assertAll(() -> verifyPawn(Color.WHITE, "p"),
                () -> verifyPawn(Color.BLACK, "P"));
    }

    void verifyPawn(Color color, final String representation) {
        Pawn pawn = new Pawn(color);
        assertAll(() -> assertThat(pawn.getColor()).isEqualTo(color),
                () -> assertThat(pawn.getColor().getRepresentation()).isEqualTo(representation));
    }
}


