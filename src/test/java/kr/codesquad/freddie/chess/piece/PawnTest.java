package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PawnTest {
    private Pawn blackPawn;
    private Pawn whitePawn;

    @BeforeEach
    void setUp() {
        blackPawn = Pawn.create(Color.BLACK);
        whitePawn = Pawn.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackPawn.getColor()).isEqualTo(Color.BLACK);
        assertThat(whitePawn.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackPawn.getKind()).isEqualTo(Kind.PAWN);
        assertThat(whitePawn.getKind()).isEqualTo(Kind.PAWN);
    }

    @Test
    void getPoint() {
        assertThat(blackPawn.getPoint()).isEqualTo(1);
    }

    @Test
    void getRepresentation() {
        assertThat(blackPawn.getRepresentation()).isEqualTo("P");
        assertThat(whitePawn.getRepresentation()).isEqualTo("p");
    }

    @Test
    void isBlack() {
        assertThat(blackPawn.isBlack()).isTrue();
        assertThat(whitePawn.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whitePawn.isWhite()).isTrue();
        assertThat(blackPawn.isWhite()).isFalse();
    }
}
