package net.honux.chess.pieces;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    void Piece의_컬러와_화면에_출력할_Representation이_각_컬러에_맞는지_확인한다() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(pawn.getColor()).isEqualTo(color);
        assertThat(pawn.getRepresentation()).isEqualTo(representation);
    }

    @Test
    void create_기본생성자() throws Exception {
        Piece pawn = new Piece();
        assertThat(pawn.getColor()).isEqualTo(pawn.WHITE_COLOR);
        assertThat(pawn.getRepresentation()).isEqualTo(Piece.WHITE_REPRESENTATION);
    }
}
