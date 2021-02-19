package chess.pieces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    public void createPiece() {
        verifyWhitePiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN);
        verifyBlackPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN);

        verifyWhitePiece(Piece.createWhiteRook(), Color.WHITE, Type.ROOK);
        verifyBlackPiece(Piece.createBlackRook(), Color.BLACK, Type.ROOK);

        verifyWhitePiece(Piece.createWhiteKnight(), Color.WHITE, Type.KNIGHT);
        verifyBlackPiece(Piece.createBlackKnight(), Color.BLACK, Type.KNIGHT);

        verifyWhitePiece(Piece.createWhiteBishop(), Color.WHITE, Type.BISHOP);
        verifyBlackPiece(Piece.createBlackBishop(), Color.BLACK, Type.BISHOP);

        verifyWhitePiece(Piece.createWhiteQueen(), Color.WHITE, Type.QUEEN);
        verifyBlackPiece(Piece.createBlackQueen(), Color.BLACK, Type.QUEEN);

        verifyWhitePiece(Piece.createWhiteKing(), Color.WHITE, Type.KING);
        verifyBlackPiece(Piece.createBlackKing(), Color.BLACK, Type.KING);
    }

    private void verifyWhitePiece(Piece piece, Color color, Type type) {
        assertThat(Piece.createWhitePawn().isWhite()).isEqualTo(true);
        assertThat(piece.getColorName()).isEqualTo(color.getColorName());
        assertThat(piece.getWhiteRepresentation()).isEqualTo(type.getWhiteRepresentation());
    }

    private void verifyBlackPiece(Piece piece, Color color, Type type) {
        assertThat(Piece.createBlackPawn().isBlack()).isEqualTo(true);
        assertThat(piece.getColorName()).isEqualTo(color.getColorName());
        assertThat(piece.getBlackRepresentation()).isEqualTo(type.getBlackRepresentation());
    }

}
