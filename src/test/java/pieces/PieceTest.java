package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    @DisplayName("생성된 기물들의 색과 representation 이 올바른지 확인")
    void createPiece() {
        verifyPiece(Piece.createWhitePawn(),Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.craeteBlakPawn(),Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);

        verifyPiece(Piece.createWhiteKnight(),Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(),Piece.WHITE_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);

        verifyPiece(Piece.createWhiteRook(),Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(),Piece.WHITE_COLOR, Piece.BLACK_ROOK_REPRESENTATION);

        verifyPiece(Piece.createWhiteBishop(),Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(),Piece.WHITE_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);

        verifyPiece(Piece.createWhiteQueen(),Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(),Piece.WHITE_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);

        verifyPiece(Piece.createWhiteKing(),Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(),Piece.WHITE_COLOR, Piece.BLACK_KING_REPRESENTATION);
    }

    void verifyPiece(final Piece piece,final String color, final char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }
}
