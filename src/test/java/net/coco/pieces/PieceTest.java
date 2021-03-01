package net.coco.pieces;

import net.coco.pieces.Piece.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("폰이 요구대로 생성되는지 테스트")
    void piecesMake() {
        Assertions.assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Color.WHITE, PieceType.PAWN),
                () -> verifyPiece(Piece.createBlackPawn(), Color.BLACK, PieceType.PAWN),

                () -> verifyPiece(Piece.createWhiteRook(), Color.WHITE, PieceType.ROOK),
                () -> verifyPiece(Piece.createBlackRook(), Color.BLACK, PieceType.ROOK),

                () -> verifyPiece(Piece.createWhiteBishop(), Color.WHITE, PieceType.BISHOP),
                () -> verifyPiece(Piece.createBlackBishop(), Color.BLACK, PieceType.BISHOP),

                () -> verifyPiece(Piece.createWhiteKing(), Color.WHITE, PieceType.KING),
                () -> verifyPiece(Piece.createBlackKing(), Color.BLACK, PieceType.KING),

                () -> verifyPiece(Piece.createWhiteKnight(), Color.WHITE, PieceType.KNIGHT),
                () -> verifyPiece(Piece.createBlackKnight(), Color.BLACK, PieceType.KNIGHT),

                () -> verifyPiece(Piece.createWhiteQueen(), Color.WHITE, PieceType.QUEEN),
                () -> verifyPiece(Piece.createBlackQueen(), Color.BLACK, PieceType.QUEEN),

                () -> verifyPiece(Piece.createBlank(), Color.NO_COLOR, PieceType.NO_PIECE)

        );

    }

    void verifyPiece(Piece piece, Color color, PieceType pieceType) {
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(pieceType).isEqualTo(piece.getPieceType());
    }

}
