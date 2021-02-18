package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("특정 색, 타입의 체스말 생성에 따라 색, 타입, 표현문자 상태 확인 ")
    void createPiece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN, Piece.WHITE_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN, Piece.BLACK_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece, Color color, Type type, final char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getType()).isEqualTo(type),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }
    ;
}
