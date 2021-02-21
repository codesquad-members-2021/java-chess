package net.honux.chess.pieces;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    void Piece의_컬러와_화면에_출력할_Representation이_각_컬러에_맞는지_확인한다() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.White.PAWN.representation);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.Black.PAWN.representation);
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    void 검색은색_흰색_말들을_구분하는_테스트() {
        assertThat(Piece.createWhiteQueen().isWhite()).isTrue();
        assertThat(Piece.createBlackBishop().isBlack()).isTrue();
    }
}
