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
                () -> verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Representation.WHITE_PAWN.getRepresentation()),
                () -> verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Representation.BLACK_PAWN.getRepresentation()),

                () -> verifyPiece(Piece.createWhiteRook(), Piece.WHITE, Representation.WHITE_ROOK.getRepresentation()),
                () -> verifyPiece(Piece.createBlackRook(), Piece.BLACK, Representation.BLACK_ROOK.getRepresentation()),

                () -> verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, Representation.WHITE_BISHOP.getRepresentation()),
                () -> verifyPiece(Piece.createBlackBishop(), Piece.BLACK, Representation.BLACK_BISHOP.getRepresentation()),

                () -> verifyPiece(Piece.createWhiteKing(), Piece.WHITE, Representation.WHITE_KING.getRepresentation()),
                () -> verifyPiece(Piece.createBlackKing(), Piece.BLACK, Representation.BLACK_KING.getRepresentation()),

                () -> verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, Representation.WHITE_KNIGHT.getRepresentation()),
                () -> verifyPiece(Piece.createBlackKnight(), Piece.BLACK, Representation.BLACK_KNIGHT.getRepresentation()),

                () -> verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, Representation.WHITE_QUEEN.getRepresentation()),
                () -> verifyPiece(Piece.createBlackQueen(), Piece.BLACK, Representation.BLACK_QUEEN.getRepresentation())

        );

    }

    void verifyPiece(Piece piece, String color, char representation) {
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }

}
