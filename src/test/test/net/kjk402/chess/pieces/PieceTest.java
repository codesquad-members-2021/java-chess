package net.kjk402.chess.pieces;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PieceTest {
    private Position position;

    @Test
    @DisplayName("모든 말을 색상별로 생성하여 확인한다.")
    void createAllPieces() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(position), Piece.Color.WHITE, Piece.Type.PAWN.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackPawn(position), Piece.Color.BLACK, Piece.Type.PAWN.getBlackRepresentation()),
                () -> verifyPiece(Piece.createWhiteRook(position), Piece.Color.WHITE, Piece.Type.ROOK.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackRook(position), Piece.Color.BLACK, Piece.Type.ROOK.getBlackRepresentation()),
                () -> verifyPiece(Piece.createWhiteKnight(position), Piece.Color.WHITE, Piece.Type.KNIGHT.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackKnight(position), Piece.Color.BLACK, Piece.Type.KNIGHT.getBlackRepresentation()),
                () -> verifyPiece(Piece.createWhiteBishop(position), Piece.Color.WHITE, Piece.Type.BISHOP.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackBishop(position), Piece.Color.BLACK, Piece.Type.BISHOP.getBlackRepresentation()),
                () -> verifyPiece(Piece.createWhiteQueen(position), Piece.Color.WHITE, Piece.Type.QUEEN.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackQueen(position), Piece.Color.BLACK, Piece.Type.QUEEN.getBlackRepresentation()),
                () -> verifyPiece(Piece.createWhiteKing(position), Piece.Color.WHITE, Piece.Type.KING.getWhiteRepresentation()),
                () -> verifyPiece(Piece.createBlackKing(position), Piece.Color.BLACK, Piece.Type.KING.getBlackRepresentation())
        );
    }

    private void verifyPiece(final Piece piece, Piece.Color color, char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }

    @Test
    void getRepresentationPerPiece() {
        assertThat(Piece.Type.PAWN.getWhiteRepresentation()).isEqualTo('p');
        assertThat(Piece.Type.PAWN.getBlackRepresentation()).isEqualTo('P');
    }

}
