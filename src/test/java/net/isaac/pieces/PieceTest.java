package net.isaac.pieces;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PieceTest {
    @Test
    @DisplayName("Pawn 생성 테스트")
    void create_Pawn() {
        Piece whitePawn = Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN);
        Piece blackPawn = Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN);
        verifyPiece(whitePawn, blackPawn, Piece.Type.PAWN);
    }

    @Test
    @DisplayName("King 생성 테스트")
    void create_King() {
        Piece whiteKing = Piece.createPiece(Piece.Color.WHITE, Piece.Type.KING);
        Piece blackKing = Piece.createPiece(Piece.Color.BLACK, Piece.Type.KING);
        verifyPiece(whiteKing, blackKing, Piece.Type.KING);
    }

    @Test
    @DisplayName("Queen 생성 테스트")
    void create_Queen() {
        Piece whiteQueen = Piece.createPiece(Piece.Color.WHITE, Piece.Type.QUEEN);
        Piece blackQueen = Piece.createPiece(Piece.Color.BLACK, Piece.Type.QUEEN);
        verifyPiece(whiteQueen, blackQueen, Piece.Type.QUEEN);
    }

    @Test
    @DisplayName("Rook 생성 테스트")
    void create_Rook() {
        Piece whiteRook = Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK);
        Piece blackRook = Piece.createPiece(Piece.Color.BLACK, Piece.Type.ROOK);
        verifyPiece(whiteRook, blackRook, Piece.Type.ROOK);
    }

    @Test
    @DisplayName("Knight 생성 테스트")
    void create_Knight() {
        Piece whiteKnight = Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT);
        Piece blackKnight = Piece.createPiece(Piece.Color.BLACK, Piece.Type.KNIGHT);
        verifyPiece(whiteKnight, blackKnight, Piece.Type.KNIGHT);
    }

    @Test
    @DisplayName("Bishop 생성 테스트")
    void create_Bishop() {
        Piece whiteBishop = Piece.createPiece(Piece.Color.WHITE, Piece.Type.BISHOP);
        Piece blackBishop = Piece.createPiece(Piece.Color.BLACK, Piece.Type.BISHOP);
        verifyPiece(whiteBishop, blackBishop, Piece.Type.BISHOP);
    }

    void verifyPiece(final Piece white, final Piece black, final Piece.Type type) {
        assertAll(
                () -> assertThat(white.getColor()).isEqualTo(Piece.Color.WHITE),
                () -> assertThat(white.getRepresentation()).isEqualTo(type.representation),
                () -> assertThat(black.getColor()).isEqualTo(Piece.Color.BLACK),
                () -> assertThat(black.getRepresentation()).isEqualTo(Character.toUpperCase(type.representation))
        );
    }

    @Test
    @DisplayName("isBlack(), isWhite() 메소드 테스트")
    void isBlack_isWhite_Test() {
        Piece white = Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN);
        Piece black = Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN);

        assertAll(
                () -> assertThat(white.isWhite()).isTrue(),
                () -> assertThat(white.isBlack()).isFalse(),
                () -> assertThat(black.isWhite()).isFalse(),
                () -> assertThat(black.isBlack()).isTrue()
        );
    }
}
