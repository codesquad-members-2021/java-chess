package net.sky.pieces;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

    @Test
    @DisplayName("팩토리 메서드로 생성된 각 piece별 인스턴스가 제대로 생성되었는지 확인")
    void createPiece() {
        PieceMaker whitePieceMaker = new PieceMaker(Color.WHITE);
        PieceMaker blackPieceMaker = new PieceMaker(Color.BLACK);


        Piece whitePawn = whitePieceMaker.createPawn();
        verifyPiece(whitePawn, Color.WHITE, 'p', PieceType.PAWN);
        Piece blackPawn = blackPieceMaker.createPawn();
        verifyPiece(blackPawn, Color.BLACK, 'P', PieceType.PAWN);

        Piece whiteKnight = whitePieceMaker.createKnight();
        verifyPiece(whiteKnight, Color.WHITE, 'n', PieceType.KNIGHT);
        Piece blackKnight = blackPieceMaker.createKnight();
        verifyPiece(blackKnight, Color.BLACK, 'N', PieceType.KNIGHT);

        Piece whiteRook = whitePieceMaker.createRook();
        verifyPiece(whiteRook, Color.WHITE, 'r', PieceType.ROOK);
        Piece blackRook = blackPieceMaker.createRook();
        verifyPiece(blackRook, Color.BLACK, 'R', PieceType.ROOK);

        Piece whiteBishop = whitePieceMaker.createBishop();
        verifyPiece(whiteBishop, Color.WHITE, 'b', PieceType.BISHOP);
        Piece blackBishop = blackPieceMaker.createBishop();
        verifyPiece(blackBishop, Color.BLACK, 'B', PieceType.BISHOP);

        Piece whiteQueen = whitePieceMaker.createQueen();
        verifyPiece(whiteQueen, Color.WHITE, 'q', PieceType.QUEEN);
        Piece blackQueen = blackPieceMaker.createQueen();
        verifyPiece(blackQueen, Color.BLACK, 'Q', PieceType.QUEEN);

        Piece whiteKing = whitePieceMaker.createKing();
        verifyPiece(whiteKing, Color.WHITE, 'k', PieceType.KING);
        Piece blackKing = blackPieceMaker.createKing();
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
