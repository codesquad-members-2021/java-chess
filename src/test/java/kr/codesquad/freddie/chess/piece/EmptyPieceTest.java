package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmptyPieceTest {
    private EmptyPiece emptyPiece;

    @BeforeEach
    void setUp() {
        emptyPiece = EmptyPiece.create();
    }

    @Test
    void getColor() {
        assertThat(emptyPiece.getColor()).isEqualTo(Color.NOCOLOR);
    }

    @Test
    void getKind() {
        assertThat(emptyPiece.getKind()).isEqualTo(Kind.EMPTY);
    }

    @Test
    void getPoint() {
        assertThat(emptyPiece.getPoint()).isEqualTo(0);
    }

    @Test
    void getRepresentation() {
        assertThat(emptyPiece.getRepresentation()).isEqualTo(".");
    }

    @Test
    void isBlack() {
        assertThat(emptyPiece.isBlack()).isFalse();
    }

    @Test
    void isWhite() {
        assertThat(emptyPiece.isWhite()).isFalse();
    }
}
