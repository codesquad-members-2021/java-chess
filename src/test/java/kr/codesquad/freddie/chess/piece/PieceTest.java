package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {
    @Test
    void create() {
        checkPieceKind("pawn", Kind.PAWN);
        checkPieceKind("knight", Kind.KNIGHT);
        checkPieceKind("rook", Kind.ROOK);
        checkPieceKind("bishop", Kind.BISHOP);
        checkPieceKind("queen", Kind.QUEEN);
        checkPieceKind("king", Kind.KING);
    }

    private void checkPieceKind(String kind, Kind expectedKind) {
        Piece whitePiece = Piece.create("white", kind);
        Piece blackPiece = Piece.create("black", kind);

        assertAll(
                () -> assertThat(whitePiece.getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(whitePiece.getKind()).isEqualTo(expectedKind),
                () -> assertThat(blackPiece.getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(blackPiece.getKind()).isEqualTo(expectedKind)
        );
    }

    @Test
    @DisplayName("검정은 대문자 하양은 소문자 반환")
    void getRepresentation() {
        assertAll(
                () -> assertThat(Piece.create("black", "pawn").getRepresentation()).isEqualTo("P"),
                () -> assertThat(Piece.create("white", "pawn").getRepresentation()).isEqualTo("p"),
                () -> assertThat(Piece.create("black", "knight").getRepresentation()).isEqualTo("K"),
                () -> assertThat(Piece.create("white", "knight").getRepresentation()).isEqualTo("k"),
                () -> assertThat(Piece.create("black", "rook").getRepresentation()).isEqualTo("R"),
                () -> assertThat(Piece.create("white", "rook").getRepresentation()).isEqualTo("r"),
                () -> assertThat(Piece.create("black", "bishop").getRepresentation()).isEqualTo("B"),
                () -> assertThat(Piece.create("white", "bishop").getRepresentation()).isEqualTo("b"),
                () -> assertThat(Piece.create("black", "queen").getRepresentation()).isEqualTo("Q"),
                () -> assertThat(Piece.create("white", "queen").getRepresentation()).isEqualTo("q"),
                () -> assertThat(Piece.create("black", "king").getRepresentation()).isEqualTo("K"),
                () -> assertThat(Piece.create("white", "king").getRepresentation()).isEqualTo("k")
        );
    }
}
