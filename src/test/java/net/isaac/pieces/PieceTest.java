package net.isaac.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("체스말 생성 테스트")
    void create_piece() {
        assertAll(
                () -> verifyPiece(Piece.createPawn(Piece.Color.WHITE), Piece.Color.WHITE, Piece.PAWN_REPRESENTATION),
                () -> verifyPiece(Piece.createPawn(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.PAWN_REPRESENTATION)),
                () -> verifyPiece(Piece.createKing(Piece.Color.WHITE), Piece.Color.WHITE, Piece.KING_REPRESENTATION),
                () -> verifyPiece(Piece.createKing(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.KING_REPRESENTATION)),
                () -> verifyPiece(Piece.createQueen(Piece.Color.WHITE), Piece.Color.WHITE, Piece.QUEEN_REPRESENTATION),
                () -> verifyPiece(Piece.createQueen(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.QUEEN_REPRESENTATION)),
                () -> verifyPiece(Piece.createRook(Piece.Color.WHITE), Piece.Color.WHITE, Piece.ROOK_REPRESENTATION),
                () -> verifyPiece(Piece.createRook(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.ROOK_REPRESENTATION)),
                () -> verifyPiece(Piece.createBishop(Piece.Color.WHITE), Piece.Color.WHITE, Piece.BISHOP_REPRESENTATION),
                () -> verifyPiece(Piece.createBishop(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.BISHOP_REPRESENTATION)),
                () -> verifyPiece(Piece.createKnight(Piece.Color.WHITE), Piece.Color.WHITE, Piece.KNIGHT_REPRESENTATION),
                () -> verifyPiece(Piece.createKnight(Piece.Color.BLACK), Piece.Color.BLACK, Character.toUpperCase(Piece.KNIGHT_REPRESENTATION))
        );
    }

    @Test
    @DisplayName("isBlack(), isWhite() 메소드 테스트")
    void isBlack_isWhite_Test() {
        Piece white = Piece.createPawn(Piece.Color.WHITE);
        Piece black = Piece.createPawn(Piece.Color.BLACK);

        assertAll(
                () -> assertThat(white.isWhite()).isEqualTo(true),
                () -> assertThat(white.isBlack()).isEqualTo(false),
                () -> assertThat(black.isWhite()).isEqualTo(false),
                () -> assertThat(black.isBlack()).isEqualTo(true)
        );
    }

    void verifyPiece(final Piece piece, final Piece.Color color, char representation) {
        assertAll(
                () -> assertThat(piece.getColor()).isEqualTo(color),
                () -> assertThat(piece.getRepresentation()).isEqualTo(representation)
        );
    }
}
