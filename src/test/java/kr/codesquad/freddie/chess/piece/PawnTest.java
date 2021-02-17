package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PawnTest {
    @Test
    void create() {
        assertAll(
                () -> assertThat(Pawn.createBlackPawn().getColor()).isEqualTo(Color.BLACK),
                () -> assertThat(Pawn.createWhitePawn().getColor()).isEqualTo(Color.WHITE)
        );
    }

    @Test
    @DisplayName("검정은 대문자 P 하양은 소문자 p 반환")
    void getRepresentation() {
        assertAll(
                () -> assertThat(Pawn.createBlackPawn().getRepresentation()).isEqualTo("P"),
                () -> assertThat(Pawn.createWhitePawn().getRepresentation()).isEqualTo("p")
        );
    }
}
