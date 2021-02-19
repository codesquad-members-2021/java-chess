package net.isaac.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("체스말 생성 테스트")
    public void create_piece() {
        assertAll(
                () -> verifyPiece(Piece.getPawn(Piece.Color.WHITE), Piece.Color.WHITE, Piece.PAWN_REPRESENTATION),
                () -> verifyPiece(Piece.getPawn(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.PAWN_REPRESENTATION)),
                () -> verifyPiece(Piece.getKing(Piece.Color.WHITE), Piece.Color.WHITE, Piece.KING_REPRESENTATION),
                () -> verifyPiece(Piece.getKing(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.KING_REPRESENTATION)),
                () -> verifyPiece(Piece.getQueen(Piece.Color.WHITE), Piece.Color.WHITE, Piece.QUEEN_REPRESENTATION),
                () -> verifyPiece(Piece.getQueen(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.QUEEN_REPRESENTATION)),
                () -> verifyPiece(Piece.getRook(Piece.Color.WHITE), Piece.Color.WHITE, Piece.ROOK_REPRESENTATION),
                () -> verifyPiece(Piece.getRook(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.ROOK_REPRESENTATION)),
                () -> verifyPiece(Piece.getBishop(Piece.Color.WHITE), Piece.Color.WHITE, Piece.BISHOP_REPRESENTATION),
                () -> verifyPiece(Piece.getBishop(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.BISHOP_REPRESENTATION)),
                () -> verifyPiece(Piece.getKnight(Piece.Color.WHITE), Piece.Color.WHITE, Piece.KNIGHT_REPRESENTATION),
                () -> verifyPiece(Piece.getKnight(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.KNIGHT_REPRESENTATION))
        );
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, char representation) {
        assertAll(
                ()->assertThat(piece.getColor()).isEqualTo(color),
                ()->assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }
}
