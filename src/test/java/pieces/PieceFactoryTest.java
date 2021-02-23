package pieces;

import org.junit.jupiter.api.*;
import pieces.Piece.*;

import static pieces.PieceFactory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PieceFactoryTest {
    @Test
    @DisplayName("색상과 타입에 알맞게 말이 생성되어야 한다")
    void verifyCreatePiece() {
        assertAll(() -> verifyPiece(createPiece(Color.WHITE, Type.PAWN), Color.WHITE, Type.PAWN),
                () -> verifyPiece(createPiece(Color.BLACK, Type.BISHOP), Color.BLACK, Type.BISHOP),
                () -> verifyPiece(createPiece(Color.WHITE, Type.QUEEN), Color.WHITE, Type.QUEEN),
                () -> verifyPiece(createPiece(Color.BLACK, Type.KING), Color.BLACK, Type.KING),
                () -> verifyPiece(createPiece(Color.NO_COLOR, Type.BLANK), Color.NO_COLOR, Type.BLANK));
    }

    private void verifyPiece(Piece piece, final Color color, final Type type) {
        assertAll(() -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getType()).isEqualTo(type));
    }
}

