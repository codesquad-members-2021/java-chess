package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {
    private King blackKing;
    private King whiteKing;

    @BeforeEach
    void setUp() {
        blackKing = King.create(Color.BLACK);
        whiteKing = King.create(Color.WHITE);
    }

    @Test
    void getColor() {
        assertThat(blackKing.getColor()).isEqualTo(Color.BLACK);
        assertThat(whiteKing.getColor()).isEqualTo(Color.WHITE);
    }

    @Test
    void getKind() {
        assertThat(blackKing.getKind()).isEqualTo(Kind.KING);
        assertThat(whiteKing.getKind()).isEqualTo(Kind.KING);
    }

    @Test
    void getPoint() {
        assertThat(blackKing.getPoint()).isEqualTo(0);
    }

    @Test
    void getRepresentation() {
        assertThat(blackKing.getRepresentation()).isEqualTo("K");
        assertThat(whiteKing.getRepresentation()).isEqualTo("k");
    }

    @Test
    void isBlack() {
        assertThat(blackKing.isBlack()).isTrue();
        assertThat(whiteKing.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(whiteKing.isWhite()).isTrue();
        assertThat(blackKing.isWhite()).isFalse();
    }
}
