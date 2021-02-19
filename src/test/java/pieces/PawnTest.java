package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("색을 지정하지 않은 Pawn(흰색이 기본값) 클래스 생성")
    void create() {
        Pawn pawn = new Pawn();
        assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR);
        assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("Pawn 클래스 인스턴스의 String color를 비교한다.")
    void compare() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation);
        assertAll(
                () -> assertThat(pawn.getColor()).isEqualTo(color),
                () -> assertThat(pawn.getRepresentation()).isEqualTo(representation)
        );
    }
}
