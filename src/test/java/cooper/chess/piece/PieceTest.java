package cooper.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {

    @Test
    @DisplayName("흰색 폰과 검정색 폰이 각각 생성됨을 확인한다.")
    public void create() {
        verifyPawn(Color.WHITE.getColorName(), Type.PAWN.getRepresentaion());
        verifyPawn(Color.BLACK.getColorName(), Type.PAWN.getRepresentaion());
    }

    void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(Color.of(color), Type.PAWN);

        assertAll(
                () -> assertEquals(color, piece.getColor().getColorName()),
                () -> assertEquals(representation, piece.getRepresentation())
        );
    }
}
