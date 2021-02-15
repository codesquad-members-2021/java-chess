package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {
    @Test
    void create() {
        assertAll(
                () -> assertThat(Piece.createBlackPawn().getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(Piece.createWhitePawn().getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(Piece.create("white", "pawn").getColor()).isEqualTo(Color.WHITE),
                () -> assertThat(Piece.create("black", "pawn").getColor()).isEqualTo(Color.BLACK)
        );
    }

    @Test
    @DisplayName("검정은 대문자 P 하양은 소문자 p 반환")
    void getRepresentation() {
        assertAll(
                () -> assertThat(Piece.createBlackPawn().getRepresentation()).isEqualTo("P"),
                () -> assertThat(Piece.createWhitePawn().getRepresentation()).isEqualTo("p"),
                () -> assertThat(Piece.create("black", "pawn").getRepresentation()).isEqualTo("P"),
                () -> assertThat(Piece.create("white", "pawn").getRepresentation()).isEqualTo("p")
        );
    }
}
