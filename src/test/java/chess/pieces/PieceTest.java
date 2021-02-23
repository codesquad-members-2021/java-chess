package chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("체스말이 정상적으로 생성되는지 확인한다.")
    public void createPieces() {
        int testPositionIndex = 1;
        Position position = new Position(testPositionIndex, testPositionIndex);
        Piece blank = Piece.createBlank(position);

        assertAll(
                () -> verifyWhitePiece(Piece.createWhitePawn(position), Type.PAWN),
                () -> verifyBlackPiece(Piece.createBlackPawn(position), Type.PAWN),

                () -> verifyWhitePiece(Piece.createWhiteRook(position), Type.ROOK),
                () -> verifyBlackPiece(Piece.createBlackRook(position), Type.ROOK),

                () -> verifyWhitePiece(Piece.createWhiteKnight(position), Type.KNIGHT),
                () -> verifyBlackPiece(Piece.createBlackKnight(position), Type.KNIGHT),

                () -> verifyWhitePiece(Piece.createWhiteBishop(position), Type.BISHOP),
                () -> verifyBlackPiece(Piece.createBlackBishop(position), Type.BISHOP),

                () -> verifyWhitePiece(Piece.createWhiteQueen(position), Type.QUEEN),
                () -> verifyBlackPiece(Piece.createBlackQueen(position), Type.QUEEN),

                () -> verifyWhitePiece(Piece.createWhiteKing(position), Type.KING),
                () -> verifyBlackPiece(Piece.createBlackKing(position), Type.KING),

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
