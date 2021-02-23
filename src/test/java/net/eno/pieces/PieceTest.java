package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("공백 기물과 모든 피스의 흰색, 검은색 기물이 생성되어야 한다.")
    public void create() {
        for (PieceType pieceType : PieceType.values()) {
            verifyPiece(pieceType);
        }
    }

    private void verifyPiece(PieceType pieceType) {
        Piece piece = Piece.createPiece(pieceType, new Position("a1"));
        assertThat(piece.getPieceType()).isEqualTo((pieceType));
        assertThat(piece.getColor()).isEqualTo(pieceType.getColor());
        assertThat(piece.getRepresentation()).isEqualTo(pieceType.getRepresentation());
        verifyPieceColor(piece);
    }

    private void verifyPieceColor(Piece piece) {
        switch (piece.getColor()) {
            case "white" :
                assertThat(piece.isWhite()).isTrue();
                break;
            case "black" :
                assertThat(piece.isBlack()).isTrue();
                break;
            default :
                assertThat(piece.isWhite()).isFalse();
                assertThat(piece.isBlack()).isFalse();
        }
    }

}
