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
        verifyPawn(Piece.createWhitePawn(), Color.WHITE, Type.PAWN.getWhiteRepresentation());
        verifyPawn(Piece.createWhiteKnight(), Color.WHITE, Type.KNIGHT.getWhiteRepresentation());
        verifyPawn(Piece.createWhiteRook(), Color.WHITE, Type.ROOK.getWhiteRepresentation());
        verifyPawn(Piece.createWhiteBishop(), Color.WHITE, Type.BISHOP.getWhiteRepresentation());
        verifyPawn(Piece.createWhiteQueen(), Color.WHITE, Type.QUEEN.getWhiteRepresentation());
        verifyPawn(Piece.createWhiteKing(), Color.WHITE, Type.KING.getWhiteRepresentation());

        verifyPawn(Piece.createBlackPawn(), Color.BLACK, Type.PAWN.getBlackRepresentation());
        verifyPawn(Piece.createBlackKnight(), Color.BLACK, Type.KNIGHT.getBlackRepresentation());
        verifyPawn(Piece.createBlackRook(), Color.BLACK, Type.ROOK.getBlackRepresentation());
        verifyPawn(Piece.createBlackBishop(), Color.BLACK, Type.BISHOP.getBlackRepresentation());
        verifyPawn(Piece.createBlackQueen(), Color.BLACK, Type.QUEEN.getBlackRepresentation());
        verifyPawn(Piece.createBlackKing(), Color.BLACK, Type.KING.getBlackRepresentation());
    }

    void verifyPawn(final Piece piece, final Color color, final char representation) {
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
        assertThat(blackPiece.isBlack()).isTrue();
        assertThat(whitePiece.isWhite()).isTrue();
    }
}
