package net.coco.pieces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("폰이 요구대로 생성되는지 테스트")
    void piecesMake() {
        Assertions.assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Piece.WHITE, PieceType.PAWN),
                () -> verifyPiece(Piece.createBlackPawn(), Piece.BLACK, PieceType.PAWN),

                () -> verifyPiece(Piece.createWhiteRook(), Piece.WHITE, PieceType.ROOK),
                () -> verifyPiece(Piece.createBlackRook(), Piece.BLACK, PieceType.ROOK),

                () -> verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, PieceType.BISHOP),
                () -> verifyPiece(Piece.createBlackBishop(), Piece.BLACK, PieceType.BISHOP),

                () -> verifyPiece(Piece.createWhiteKing(), Piece.WHITE, PieceType.KING),
                () -> verifyPiece(Piece.createBlackKing(), Piece.BLACK, PieceType.KING),

                () -> verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, PieceType.KNIGHT),
                () -> verifyPiece(Piece.createBlackKnight(), Piece.BLACK, PieceType.KNIGHT),

                () -> verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, PieceType.QUEEN),
                () -> verifyPiece(Piece.createBlackQueen(), Piece.BLACK, PieceType.QUEEN),

                () -> verifyPiece(Piece.createBlank(), Piece.NO_COLOR, PieceType.NO_PIECE)

        );

    }

    void verifyPiece(Piece piece, String color, PieceType pieceType) {
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(pieceType.getRepresentation(color)).isEqualTo(piece.getRepresentation());
    }

}
