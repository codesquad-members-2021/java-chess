package net.sky.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {


    @Test
    @DisplayName("팩토리 메서드로 생성된 각 piece별 인스턴스가 제대로 생성되었는지 확인")
    void createPiece() {
        Piece whitePawn = Piece.getPawnInstance(Color.WHITE);
        verifyPiece(whitePawn, Color.WHITE, 'p', PieceType.PAWN);
        Piece blackPawn = Piece.getPawnInstance(Color.BLACK);
        verifyPiece(blackPawn, Color.BLACK, 'P', PieceType.PAWN);

        Piece whiteKnight = Piece.getKnightInstance(Color.WHITE);
        verifyPiece(whiteKnight, Color.WHITE, 'n', PieceType.KNIGHT);
        Piece blackKnight = Piece.getKnightInstance(Color.BLACK);
        verifyPiece(blackKnight, Color.BLACK, 'N', PieceType.KNIGHT);

        Piece whiteRook = Piece.getRookInstance(Color.WHITE);
        verifyPiece(whiteRook, Color.WHITE, 'r', PieceType.ROOK);
        Piece blackRook = Piece.getRookInstance(Color.BLACK);
        verifyPiece(blackRook, Color.BLACK, 'R', PieceType.ROOK);

        Piece whiteBishop = Piece.getBishopInstance(Color.WHITE);
        verifyPiece(whiteBishop, Color.WHITE, 'b', PieceType.BISHOP);
        Piece blackBishop = Piece.getBishopInstance(Color.BLACK);
        verifyPiece(blackBishop, Color.BLACK, 'B', PieceType.BISHOP);

        Piece whiteQueen = Piece.getQueenInstance(Color.WHITE);
        verifyPiece(whiteQueen, Color.WHITE, 'q', PieceType.QUEEN);
        Piece blackQueen = Piece.getQueenInstance(Color.BLACK);
        verifyPiece(blackQueen, Color.BLACK, 'Q', PieceType.QUEEN);

        Piece whiteKing = Piece.getKingInstance(Color.WHITE);
        verifyPiece(whiteKing, Color.WHITE, 'k', PieceType.KING);
        Piece blackKing = Piece.getKingInstance(Color.BLACK);
        verifyPiece(blackKing, Color.BLACK, 'K', PieceType.KING);
    }

    void verifyPiece(final Piece piece, final Color color, final char representation,
        final PieceType pieceType) {
        assertAll(
            () -> assertThat(piece.getColor()).isEqualTo(color),
            () -> assertThat(piece.getRepresentation()).isEqualTo(representation),
            () -> assertThat(piece.getPieceType()).isEqualTo(pieceType),
            () -> assertThat(verifyColor(piece, color)).isTrue()
        );
    }

    private boolean verifyColor(Piece piece, Color color) {
        if (color == Color.BLACK) {
            return piece.isBlack(piece);
        }
        return piece.isWhite(piece);
    }

}
