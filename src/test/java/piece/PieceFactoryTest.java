package piece;

import org.junit.jupiter.api.*;
import piece.attribute.*;

import static piece.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PieceFactoryTest {
    @Test
    @DisplayName("색상과 타입에 알맞게 말이 생성되어야 한다")
    void verifyCreatePiece() {
        assertAll(() -> verifyPiece(createPiece(Color.WHITE, Type.PAWN, "a2"), Color.WHITE, Type.PAWN),
                () -> verifyPiece(createPiece(Color.BLACK, Type.BISHOP,"c8" ), Color.BLACK, Type.BISHOP),
                () -> verifyPiece(createPiece(Color.WHITE, Type.QUEEN, "d1"), Color.WHITE, Type.QUEEN),
                () -> verifyPiece(createPiece(Color.NO_COLOR, Type.BLANK, "a6"), Color.NO_COLOR, Type.BLANK));
    }

    void verifyPiece(Piece piece, final Color color, final Type type) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getType()).isEqualTo(type));
    }
}

