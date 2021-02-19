package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {
    @Test
    void create() {
        checkPieceKind(Kind.PAWN);
        checkPieceKind(Kind.KNIGHT);
        checkPieceKind(Kind.ROOK);
        checkPieceKind(Kind.BISHOP);
        checkPieceKind(Kind.QUEEN);
        checkPieceKind(Kind.KING);
    }

    private void checkPieceKind(Kind expectedKind) {
        Piece whitePiece = new Piece(Color.WHITE, expectedKind);
        Piece blackPiece = new Piece(Color.BLACK, expectedKind);

        assertAll(
                () -> assertThat(whitePiece.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whitePiece.getKind()).isEqualTo(expectedKind),
                () -> assertThat(blackPiece.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackPiece.getKind()).isEqualTo(expectedKind)
        );
    }

    @Test
    void createBlank() {
        assertThat(Piece.createBlank()).isEqualTo(new Piece(Color.NOCOLOR, Kind.EMPTY));
    }

    @Test
    @DisplayName("검정은 대문자 하양은 소문자 반환")
    void getRepresentation() {
        assertAll(
                () -> assertThat(new Piece(Color.BLACK, Kind.PAWN).getRepresentation()).isEqualTo("P"),
                () -> assertThat(new Piece(Color.WHITE, Kind.PAWN).getRepresentation()).isEqualTo("p"),
                () -> assertThat(new Piece(Color.BLACK, Kind.KNIGHT).getRepresentation()).isEqualTo("N"),
                () -> assertThat(new Piece(Color.WHITE, Kind.KNIGHT).getRepresentation()).isEqualTo("n"),
                () -> assertThat(new Piece(Color.BLACK, Kind.ROOK).getRepresentation()).isEqualTo("R"),
                () -> assertThat(new Piece(Color.WHITE, Kind.ROOK).getRepresentation()).isEqualTo("r"),
                () -> assertThat(new Piece(Color.BLACK, Kind.BISHOP).getRepresentation()).isEqualTo("B"),
                () -> assertThat(new Piece(Color.WHITE, Kind.BISHOP).getRepresentation()).isEqualTo("b"),
                () -> assertThat(new Piece(Color.BLACK, Kind.QUEEN).getRepresentation()).isEqualTo("Q"),
                () -> assertThat(new Piece(Color.WHITE, Kind.QUEEN).getRepresentation()).isEqualTo("q"),
                () -> assertThat(new Piece(Color.BLACK, Kind.KING).getRepresentation()).isEqualTo("K"),
                () -> assertThat(new Piece(Color.WHITE, Kind.KING).getRepresentation()).isEqualTo("k"),
                () -> assertThat(new Piece(Color.NOCOLOR, Kind.EMPTY).getRepresentation()).isEqualTo(".")
        );
    }

    @Test
    void isBlack() {
        assertAll(
                () -> assertThat(new Piece(Color.BLACK, Kind.PAWN).isBlack()).isTrue(),
                () -> assertThat(new Piece(Color.BLACK, Kind.KNIGHT).isBlack()).isTrue(),
                () -> assertThat(new Piece(Color.BLACK, Kind.ROOK).isBlack()).isTrue(),
                () -> assertThat(new Piece(Color.BLACK, Kind.BISHOP).isBlack()).isTrue(),
                () -> assertThat(new Piece(Color.BLACK, Kind.QUEEN).isBlack()).isTrue(),
                () -> assertThat(new Piece(Color.BLACK, Kind.KING).isBlack()).isTrue()
        );
    }

    @Test
    void isBlack_not_a_black() {
        assertAll(
                () -> assertThat(new Piece(Color.WHITE, Kind.PAWN).isBlack()).isFalse(),
                () -> assertThat(new Piece(Color.WHITE, Kind.KNIGHT).isBlack()).isFalse(),
                () -> assertThat(new Piece(Color.WHITE, Kind.ROOK).isBlack()).isFalse(),
                () -> assertThat(new Piece(Color.WHITE, Kind.BISHOP).isBlack()).isFalse(),
                () -> assertThat(new Piece(Color.WHITE, Kind.QUEEN).isBlack()).isFalse(),
                () -> assertThat(new Piece(Color.WHITE, Kind.KING).isBlack()).isFalse(),
                () -> assertThat(new Piece(Color.NOCOLOR, Kind.EMPTY).isBlack()).isFalse()
        );
    }

    @Test
    void isWhite() {
        assertAll(
                () -> assertThat(new Piece(Color.WHITE, Kind.PAWN).isWhite()).isTrue(),
                () -> assertThat(new Piece(Color.WHITE, Kind.KNIGHT).isWhite()).isTrue(),
                () -> assertThat(new Piece(Color.WHITE, Kind.ROOK).isWhite()).isTrue(),
                () -> assertThat(new Piece(Color.WHITE, Kind.BISHOP).isWhite()).isTrue(),
                () -> assertThat(new Piece(Color.WHITE, Kind.QUEEN).isWhite()).isTrue(),
                () -> assertThat(new Piece(Color.WHITE, Kind.KING).isWhite()).isTrue()
        );
    }

    @Test
    void isWhite_not_a_white() {
        assertAll(
                () -> assertThat(new Piece(Color.BLACK, Kind.PAWN).isWhite()).isFalse(),
                () -> assertThat(new Piece(Color.BLACK, Kind.KNIGHT).isWhite()).isFalse(),
                () -> assertThat(new Piece(Color.BLACK, Kind.ROOK).isWhite()).isFalse(),
                () -> assertThat(new Piece(Color.BLACK, Kind.BISHOP).isWhite()).isFalse(),
                () -> assertThat(new Piece(Color.BLACK, Kind.QUEEN).isWhite()).isFalse(),
                () -> assertThat(new Piece(Color.BLACK, Kind.KING).isWhite()).isFalse(),
                () -> assertThat(new Piece(Color.NOCOLOR, Kind.EMPTY).isWhite()).isFalse()
        );
    }
}
