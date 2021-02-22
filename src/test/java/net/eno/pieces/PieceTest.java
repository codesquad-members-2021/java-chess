package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("모든 피스의 흰색말과 검은색말이 생성되어야 한다.")
    public void create() {
        for (PieceType pieceType : PieceType.values()) {
            verifyPiece(pieceType);
        }
    }

    public void verifyPiece(PieceType pieceType) {
        Piece piece = Piece.createPiece(pieceType);
        assertThat(piece.getColor()).isEqualTo(pieceType.getColor());
        assertThat(piece.getRepresentation()).isEqualTo(pieceType.getRepresentation());
    }

}
