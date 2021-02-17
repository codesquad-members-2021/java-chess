package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("모든 피스의 흰색말과 검은색말이 생성되어야 한다.")
    public void create() {
        verifyPiece(Color.WHITE, Representation.PAWN);
        verifyPiece(Color.BLACK, Representation.PAWN);
        verifyPiece(Color.WHITE, Representation.KNIGHT);
        verifyPiece(Color.BLACK, Representation.KNIGHT);
        verifyPiece(Color.WHITE, Representation.ROOK);
        verifyPiece(Color.BLACK, Representation.ROOK);
        verifyPiece(Color.WHITE, Representation.BISHOP);
        verifyPiece(Color.BLACK, Representation.BISHOP);
        verifyPiece(Color.WHITE, Representation.QUEEN);
        verifyPiece(Color.BLACK, Representation.QUEEN);
        verifyPiece(Color.WHITE, Representation.KING);
        verifyPiece(Color.BLACK, Representation.KING);
    }

    public void verifyPiece(Color color, Representation representation) {
        Piece piece = Piece.createPiece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color.toString());
        assertThat(piece.getRepresentation()).isEqualTo(representation.get(color));
    }

}
