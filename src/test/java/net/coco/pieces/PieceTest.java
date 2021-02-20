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
                () -> verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Representation.PAWN.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Representation.PAWN.getBlackRepresentation()),

                () -> verifyPiece(Piece.createWhiteRook(), Piece.WHITE, Representation.ROOK.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackRook(), Piece.BLACK, Representation.ROOK.getBlackRepresentation()),

                () -> verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, Representation.BISHOP.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackBishop(), Piece.BLACK, Representation.BISHOP.getBlackRepresentation()),

                () -> verifyPiece(Piece.createWhiteKing(), Piece.WHITE, Representation.KING.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackKing(), Piece.BLACK, Representation.KING.getBlackRepresentation()),

                () -> verifyPiece(Piece.createWhiteKnight(), Piece.WHITE, Representation.KNIGHT.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackKnight(), Piece.BLACK, Representation.KNIGHT.getBlackRepresentation()),

                () -> verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, Representation.QUEEN.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackQueen(), Piece.BLACK, Representation.QUEEN.getBlackRepresentation())

        );

    }

    void verifyPiece(Piece piece, String color, char representation) {
        assertThat(color).isEqualTo(piece.getColor());
        assertThat(representation).isEqualTo(piece.getRepresentation());
    }

}
