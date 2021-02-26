package net.tree.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @DisplayName("모든 말 생성하기")
    @Test
    void createAllPieces() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Pieces.WHITE_PAWN.getRepresentation());
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Pieces.BLACK_PAWN.getRepresentation());
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Pieces.WHITE_KNIGHT.getRepresentation());
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Pieces.BLACK_KNIGHT.getRepresentation());
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Pieces.WHITE_BISHOP.getRepresentation());
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Pieces.BLACK_BISHOP.getRepresentation());
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Pieces.WHITE_ROOK.getRepresentation());
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Pieces.BLACK_ROOK.getRepresentation());
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Pieces.WHITE_QUEEN.getRepresentation());
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Pieces.BLACK_QUEEN.getRepresentation());
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Pieces.WHITE_KING.getRepresentation());
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Pieces.BLACK_KING.getRepresentation());
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }

    @DisplayName("무작위의 피스의 이름이 맞는지 검증")
    @Test
    void checkPiecesName() {
        assertAll(
                () -> assertThat(Piece.createWhiteQueen().getName()).isEqualTo(Pieces.WHITE_QUEEN.name()),
                () -> assertThat(Piece.createBlackRook().getName()).isEqualTo(Pieces.BLACK_ROOK.name())
        );
    }

    @DisplayName("무작위의 피스의 색상이 맞는지 검증")
    @Test
    void checkColorOfPiece() {
        assertAll(
                () -> assertThat(Piece.createWhiteBishop().isWhite()).isTrue(),
                () -> assertThat(Piece.createBlackKing().isBlack()).isTrue(),
                () -> assertThat(Piece.createWhiteQueen().isBlack()).isFalse(),
                () -> assertThat(Piece.createBlackKnight().isWhite()).isFalse()
        );
    }




}
