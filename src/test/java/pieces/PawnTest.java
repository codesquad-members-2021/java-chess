package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("색을 지정하지 않을때 흰색 폰이 생성된다.")
    void create() {
        Piece pawn = new Piece();
        assertThat(pawn.getColor()).isEqualTo(Piece.WHITE_COLOR);
        assertThat(pawn.getRepresentation()).isEqualTo(Piece.WHITE_REPRESENTATION);
    }

    @Test
    @DisplayName("Pawn 클래스 인스턴스의 String color를 비교한다.")
    void compare() {
        verifyPawn(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    void verifyPawn(final String color, final char representation) {
        Piece pawn = new Piece(color, representation);
        assertAll(
                () -> assertThat(pawn.getColor()).isEqualTo(color),
                () -> assertThat(pawn.getRepresentation()).isEqualTo(representation)
        );
    }
}
