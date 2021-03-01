package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BishopTest {
    private Bishop blackBishop;
    private Bishop whiteBishop;

    @BeforeEach
    void setUp() {
        blackBishop = Bishop.create(Color.BLACK);
        whiteBishop = Bishop.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackBishop.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteBishop.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackBishop.getKind()).isEqualTo(Kind.BISHOP);
        assertThat(whiteBishop.getKind()).isEqualTo(Kind.BISHOP);
    }

    @Test
    void getPoint() {
        assertThat(blackBishop.getPoint()).isEqualTo(3);
    }

    @Test
    void getRepresentation() {
        assertThat(blackBishop.getRepresentation()).isEqualTo("B");
        assertThat(whiteBishop.getRepresentation()).isEqualTo("b");
    }

    @Test
    void isBlack() {
        assertThat(blackBishop.isBlack()).isTrue();
        assertThat(whiteBishop.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteBishop.isWhite()).isTrue();
        assertThat(blackBishop.isWhite()).isFalse();
    }
}
