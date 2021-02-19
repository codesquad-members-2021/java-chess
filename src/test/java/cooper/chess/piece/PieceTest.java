package cooper.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰이 생성됨을 확인한다.")
    public void create_defaultConstructor() {
        Piece piece = new Piece();
        assertEquals(Color.WHITE.getColorName(), piece.getColor().getColorName());
        assertEquals(Color.WHITE.getRepresentation(), piece.getRepresentation());
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
        assertThrows(IllegalArgumentException.class, () -> new Piece("green"));
    }

    void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color);

        assertAll(
                () -> assertEquals(color, piece.getColor().getColorName()),
                () -> assertEquals(representation, piece.getRepresentation())
        );
    }
}
