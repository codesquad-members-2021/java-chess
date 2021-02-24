package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("공백 기물과 모든 피스의 흰색, 검은색 기물이 생성되어야 한다.")
    public void create() {
        for (PieceType pieceType : PieceType.values()) {
            verifyPiece(Color.WHITE, pieceType);
            verifyPiece(Color.BLACK, pieceType);
        }
    }

    private void verifyPiece(Color color, PieceType pieceType) {
        Piece piece = Piece.createPiece(color, pieceType);
        assertThat(piece.getPieceType()).isEqualTo((pieceType));
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation(color)).isEqualTo(pieceType.getRepresentation(color));
        verifyPieceColor(piece);
    }

    private void verifyPieceColor(Piece piece) {
        Color PieceColor = piece.getColor();
        if (PieceColor.equals(Color.WHITE)) {
            assertThat(piece.isWhite()).isTrue();
        } else if (PieceColor.equals(Color.BLACK)) {
            assertThat(piece.isBlack()).isTrue();
        } else {
            assertThat(piece.isWhite()).isFalse();
            assertThat(piece.isBlack()).isFalse();
        }
    }

}
