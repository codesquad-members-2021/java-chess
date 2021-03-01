package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {
    private Knight blackKnight;
    private Knight whiteKnight;

    @BeforeEach
    void setUp() {
        blackKnight = Knight.create(Color.BLACK);
        whiteKnight = Knight.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackKnight.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteKnight.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackKnight.getKind()).isEqualTo(Kind.KNIGHT);
        assertThat(whiteKnight.getKind()).isEqualTo(Kind.KNIGHT);
    }

    @Test
    void getPoint() {
        assertThat(blackKnight.getPoint()).isEqualTo(2.5);
    }

    @Test
    void getRepresentation() {
        assertThat(blackKnight.getRepresentation()).isEqualTo("N");
        assertThat(whiteKnight.getRepresentation()).isEqualTo("n");
    }

    @Test
    void isBlack() {
        assertThat(blackKnight.isBlack()).isTrue();
        assertThat(whiteKnight.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteKnight.isWhite()).isTrue();
        assertThat(blackKnight.isWhite()).isFalse();
    }
}
