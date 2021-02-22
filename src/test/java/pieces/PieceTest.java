package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("생성된 기물들의 색과 representation 이 올바른지 확인")
    void createPiece() {
        verifyPiece(Piece.createWhitePawn(),Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPiece(Piece.craeteBlakPawn(),Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }

    void verifyPiece(final Piece piece,final String color, final char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }
}
