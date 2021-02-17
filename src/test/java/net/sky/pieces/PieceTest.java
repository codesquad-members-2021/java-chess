package net.sky.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {


    @Test
    @DisplayName("각 piece별 흰색 말, 검은 색 말 객체가 제대로 생성 되었는지 확인")
    void createPiece() {
        Piece whitePawn = Piece.createPiece(Color.WHITE, PieceType.PAWN);
        verifyPiece(whitePawn, Color.WHITE, 'p', PieceType.PAWN);
        Piece blackPawn = Piece.createPiece(Color.BLACK, PieceType.PAWN);
        verifyPiece(blackPawn, Color.BLACK, 'P', PieceType.PAWN);

        Piece whiteKnight = Piece.createPiece(Color.WHITE, PieceType.KNIGHT);
        verifyPiece(whiteKnight, Color.WHITE, 'n', PieceType.KNIGHT);
        Piece blackKnight = Piece.createPiece(Color.BLACK, PieceType.KNIGHT);
        verifyPiece(blackKnight, Color.BLACK, 'N', PieceType.KNIGHT);

        Piece whiteRook = Piece.createPiece(Color.WHITE, PieceType.ROOK);
        verifyPiece(whiteRook, Color.WHITE, 'r', PieceType.ROOK);
        Piece blackRook = Piece.createPiece(Color.BLACK, PieceType.ROOK);
        verifyPiece(blackRook, Color.BLACK, 'R', PieceType.ROOK);

        Piece whiteBishop = Piece.createPiece(Color.WHITE, PieceType.BISHOP);
        verifyPiece(whiteBishop, Color.WHITE, 'b', PieceType.BISHOP);
        Piece blackBishop = Piece.createPiece(Color.BLACK, PieceType.BISHOP);
        verifyPiece(blackBishop, Color.BLACK, 'B', PieceType.BISHOP);

        Piece whiteQueen = Piece.createPiece(Color.WHITE, PieceType.QUEEN);
        verifyPiece(whiteQueen, Color.WHITE, 'q', PieceType.QUEEN);
        Piece blackQueen = Piece.createPiece(Color.BLACK, PieceType.QUEEN);
        verifyPiece(blackQueen, Color.BLACK, 'Q', PieceType.QUEEN);

        Piece whiteKing = Piece.createPiece(Color.WHITE, PieceType.KING);
        verifyPiece(whiteKing, Color.WHITE, 'k', PieceType.KING);
        Piece blackKing = Piece.createPiece(Color.BLACK, PieceType.KING);
        verifyPiece(blackKing, Color.BLACK, 'K', PieceType.KING);

    }

    void verifyPiece(final Piece piece, final Color color, final char representation,
        final PieceType pieceType) {
        assertAll(
            () -> assertThat(piece.getColor()).isEqualTo(color),
            () -> assertThat(piece.getRepresentation()).isEqualTo(representation),
            () -> assertThat(piece.getPieceType()).isEqualTo(pieceType)
        );
    }

}
