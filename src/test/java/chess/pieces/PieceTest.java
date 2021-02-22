package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

        Piece blank = Piece.createBlank();
        assertAll(
                () -> assertThat(blank.isWhite()).isEqualTo(false),
                () -> assertThat(blank.isBlack()).isEqualTo(false),
                () -> assertThat(blank.getColor()).isEqualTo(Color.NO_COLOR),
                () -> assertThat(blank.getRepresentation()).isEqualTo(Type.BLANK.getWhiteRepresentation())
        );
    }

    private void verifyWhitePiece(Piece piece, Type type) {
        assertAll(
                () -> assertThat(piece.isWhite()).isEqualTo(true),
                () -> assertThat(piece.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(piece.getRepresentation()).isEqualTo(type.getWhiteRepresentation())
        );
    }

    private void verifyBlackPiece(Piece piece, Type type) {
        assertAll(
                () -> assertThat(piece.isBlack()).isEqualTo(true),
                () -> assertThat(piece.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(piece.getRepresentation()).isEqualTo(type.getBlackRepresentation())
        );
    }

}
