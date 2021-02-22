package net.sally.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class PieceTest {

    @Test
    void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK, Piece.BLACK_PAWN_REPRESENTATION);

        verifyPiece(Piece.createWhiteRook(), Piece.WHITE, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(), Piece.BLACK , Piece.BLACK_ROOK_REPRESENTATION);

        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK, Piece.BLACK_BISHOP_REPRESENTATION);

        verifyPiece(Piece.createWhiteKing(), Piece.WHITE, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(), Piece.BLACK, Piece.BLACK_KING_REPRESENTATION);

        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK, Piece.BLACK_QUEEN_REPRESENTATION);
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }

    @Test
    @DisplayName("isWhite()과 isBlack()이 정상적으로 작동하는지 확인")
    void isColorTest() {
        Piece blackPawn = Piece.createBlackPawn();
        Piece whitePawn = Piece.createWhitePawn();

        assertThat(blackPawn.isBlack()).isEqualTo(blackPawn.getColor().equals("black"));
        assertThat(whitePawn.isWhite()).isEqualTo(whitePawn.getColor().equals("white"));
        assertThat(blackPawn.isWhite()).isEqualTo(blackPawn.getColor().equals("white"));
        assertThat(whitePawn.isBlack()).isEqualTo(whitePawn.getColor().equals("black"));
    }
}
