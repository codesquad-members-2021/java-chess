package net.kjk402.chess.pieces;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {
    @Test
    @DisplayName("기본 생성자 실행 시 흰색폰이 생성된다.")
    void create_기본생성자() throws Exception {
        Piece piece = new Piece();
        assertEquals(Piece.WHITE, piece.getColor());
        assertEquals(Piece.WHITE_REPRESENTATION, piece.getRepresentation());
    }

    @Test
    void createPawn() {
        verifyPawn(Piece.WHITE, Piece.WHITE_REPRESENTATION);
        verifyPawn(Piece.BLACK, Piece.BLACK_REPRESENTATION);
    }

    private void verifyPawn(final String color, final char representation) {
        Piece piece = new Piece(color, representation);
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }

}
