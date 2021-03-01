package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {
    private Rook blackRook;
    private Rook whiteRook;

    @BeforeEach
    void setUp() {
        blackRook = Rook.create(Color.BLACK);
        whiteRook = Rook.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackRook.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteRook.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackRook.getKind()).isEqualTo(Kind.ROOK);
        assertThat(whiteRook.getKind()).isEqualTo(Kind.ROOK);
    }

    @Test
    void getPoint() {
        assertThat(blackRook.getPoint()).isEqualTo(5);
    }

    @Test
    void getRepresentation() {
        assertThat(blackRook.getRepresentation()).isEqualTo("R");
        assertThat(whiteRook.getRepresentation()).isEqualTo("r");
    }

    @Test
    void isBlack() {
        assertThat(blackRook.isBlack()).isTrue();
        assertThat(whiteRook.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteRook.isWhite()).isTrue();
        assertThat(blackRook.isWhite()).isFalse();
    }
}
