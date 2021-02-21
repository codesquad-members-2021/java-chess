package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("모든 피스의 흰색말과 검은색말이 생성되어야 한다.")
    public void create() {
        for (PieceType pieceType : PieceType.values()) {
            verifyPiece(Color.WHITE, pieceType);
            verifyPiece(Color.BLACK, pieceType);
        }
    }

    public void verifyPiece(Color color, PieceType pieceType) {
        Piece piece = Piece.createPiece(color, pieceType);
        assertThat(piece.getColor()).isEqualTo(color.toString());
        assertThat(piece.getRepresentation()).isEqualTo(pieceType.getRepresentation(color));
    }

}
