package pieces;

import pieces.Piece.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {
    @Test
    @DisplayName("piece의 type별로 흰/검 말이 생성되어야 한다")
    void createPiece() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Type.KNIGHT.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createWhiteRook(), Color.WHITE, Type.ROOK.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Type.BISHOP.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Type.QUEEN.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createWhiteKing(), Color.WHITE, Type.KING.getWhiteRepresentation()),

                () -> verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN.getBlackRepresentation()),
                () -> verifyPiece(Piece.createBlackKnight(), Color.BLACK, Type.KNIGHT.getBlackRepresentation()),
                () -> verifyPiece(Piece.createBlackRook(), Color.BLACK, Type.ROOK.getBlackRepresentation()),
                () -> verifyPiece(Piece.createBlackBishop(), Color.BLACK, Type.BISHOP.getBlackRepresentation()),
                () -> verifyPiece(Piece.createBlackQueen(), Color.BLACK, Type.QUEEN.getBlackRepresentation()),
                () -> verifyPiece(Piece.createBlackKing(), Color.BLACK, Type.KING.getBlackRepresentation())
        );
    }

    private void verifyPiece(final Piece piece, final Color color, final char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }

    @Test
    @DisplayName("체스 말의 색을 isWhite(), isBlack()로 확인할 수 있어야한다")
    void checkColor() {
        Piece blackPiece = Piece.createBlackPawn();
        Piece whitePiece = Piece.createWhitePawn();
        assertAll(
                () -> assertThat(blackPiece.isBlack()).isTrue(),
                () -> assertThat(whitePiece.isWhite()).isTrue()
        );
    }
}
