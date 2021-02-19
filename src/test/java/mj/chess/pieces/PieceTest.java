package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("체스말 생성에 따라 색, 타입, 표현문자 상태 확인 ")
    void createPiece() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN),
                () -> verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN)
        );
    };

    private void verifyPiece(final Piece piece, Color color, Type type) {
        char representation = new RepresentationMap().getRepresentation(color, type);

        assertAll(
                () -> verifyColorOfPiece(piece, color),
                () -> verifyTypeOfPiece(piece, type),
                () -> verifyRepresentationOfPiece(piece, representation)
        );
    };

    private void verifyColorOfPiece(final Piece piece, Color color) {
        assertThat(piece.getColor()).isEqualTo(color);
    };

    private void verifyTypeOfPiece(final Piece piece, Type type) {
        assertThat(piece.getType()).isEqualTo(type);
    };

    private void verifyRepresentationOfPiece(final Piece piece, final char representation) {
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    };
}
