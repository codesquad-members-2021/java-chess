package cooper.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성됨을 확인한다.")
    public void create_defaultConstructor() {
        Pawn pawn = new Pawn();
        assertEquals(Color.WHITE.getColorName(), pawn.getColor().getColorName());
        assertEquals(Color.WHITE.getRepresentation(), pawn.getRepresentation());
    }

    @Test
    @DisplayName("흰색 폰과 검정색 폰이 각각 생성됨을 확인한다.")
    public void create() {
        verifyPawn(Color.WHITE.getColorName(), Color.WHITE.getRepresentation());
        verifyPawn(Color.BLACK.getColorName(), Color.BLACK.getRepresentation());
    }

    @Test
    @DisplayName("흰색과 검정색 외 색상 추가 시, 예외를 발생시킨다.")
    public void checkOtherColorName() {
        assertThrows(IllegalArgumentException.class, () -> new Pawn("green"));
    }

    void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color);

        assertAll(
                () -> assertEquals(color, pawn.getColor().getColorName()),
                () -> assertEquals(representation, pawn.getRepresentation())
        );
    }
}
