package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueenTest {
    private Queen blackQueen;
    private Queen whiteQueen;

    @BeforeEach
    void setUp() {
        blackQueen = Queen.create(Color.BLACK);
        whiteQueen = Queen.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackQueen.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteQueen.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackQueen.getKind()).isEqualTo(Kind.QUEEN);
        assertThat(whiteQueen.getKind()).isEqualTo(Kind.QUEEN);
    }

    @Test
    void getPoint() {
        assertThat(blackQueen.getPoint()).isEqualTo(9);
    }

    @Test
    void getRepresentation() {
        assertThat(blackQueen.getRepresentation()).isEqualTo("Q");
        assertThat(whiteQueen.getRepresentation()).isEqualTo("q");
    }

    @Test
    void isBlack() {
        assertThat(blackQueen.isBlack()).isTrue();
        assertThat(whiteQueen.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteQueen.isWhite()).isTrue();
        assertThat(blackQueen.isWhite()).isFalse();
    }
}
