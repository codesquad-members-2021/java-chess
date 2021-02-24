package net.tree.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PieceTest {

    @DisplayName("모든 말 생성하기")
    @Test
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.enumPieces.WHITE_PAWN.getRepresentation());
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.enumPieces.BLACK_PAWN.getRepresentation());
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.enumPieces.WHITE_KNIGHT.getRepresentation());
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.enumPieces.BLACK_KNIGHT.getRepresentation());
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.enumPieces.WHITE_BISHOP.getRepresentation());
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.enumPieces.BLACK_BISHOP.getRepresentation());
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.enumPieces.WHITE_ROOK.getRepresentation());
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.enumPieces.BLACK_ROOK.getRepresentation());
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.enumPieces.WHITE_QUEEN.getRepresentation());
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.enumPieces.BLACK_QUEEN.getRepresentation());
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.enumPieces.WHITE_KING.getRepresentation());
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.enumPieces.BLACK_KING.getRepresentation());
    }


    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );

    }

}
