package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceTest {

    @Test
    @DisplayName("체스말이 정상적으로 생성되는지 확인한다.")
    public void createPieces() {
        verifyWhitePiece(Piece.createWhitePawn(), Type.PAWN);
        verifyBlackPiece(Piece.createBlackPawn(), Type.PAWN);

        verifyWhitePiece(Piece.createWhiteRook(), Type.ROOK);
        verifyBlackPiece(Piece.createBlackRook(), Type.ROOK);

        verifyWhitePiece(Piece.createWhiteKnight(), Type.KNIGHT);
        verifyBlackPiece(Piece.createBlackKnight(), Type.KNIGHT);

        verifyWhitePiece(Piece.createWhiteBishop(), Type.BISHOP);
        verifyBlackPiece(Piece.createBlackBishop(), Type.BISHOP);

        verifyWhitePiece(Piece.createWhiteQueen(), Type.QUEEN);
        verifyBlackPiece(Piece.createBlackQueen(), Type.QUEEN);

        verifyWhitePiece(Piece.createWhiteKing(), Type.KING);
        verifyBlackPiece(Piece.createBlackKing(), Type.KING);
    }

    private void verifyWhitePiece(Piece piece, Type type) {
        assertThat(piece.isWhite()).isEqualTo(true);
        assertThat(piece.getColorName()).isEqualTo(Color.WHITE.getColorName());
        assertThat(piece.getRepresentation()).isEqualTo(type.getWhiteRepresentation());
    }

    private void verifyBlackPiece(Piece piece, Type type) {
        assertThat(piece.isBlack()).isEqualTo(true);
        assertThat(piece.getColorName()).isEqualTo(Color.BLACK.getColorName());
        assertThat(piece.getRepresentation()).isEqualTo(type.getBlackRepresentation());
    }

}
