package net.eno.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("모든 피스의 흰색말과 검은색말이 생성되어야 한다.")
    public void create() {
        for (Representation representation : Representation.values()) {
            verifyPiece(Color.WHITE, representation);
            verifyPiece(Color.BLACK, representation);
        }
    }

    public void verifyPiece(Color color, Representation representation) {
        Piece piece = Piece.createPiece(color, representation);
        assertThat(piece.getColor()).isEqualTo(color.toString());
        assertThat(piece.getRepresentation()).isEqualTo(representation.get(color));
    }

}
