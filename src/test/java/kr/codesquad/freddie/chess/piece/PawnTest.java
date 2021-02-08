package kr.codesquad.freddie.chess.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PawnTest {

    @Test
    @DisplayName("흰색 생성")
    void create_white() {
        assertThat(Pawn.create("white"))
                .isEqualTo(new Pawn(Color.WHITE));
    }

    @Test
    @DisplayName("검은색 생성")
    void create_black() {
        assertThat(Pawn.create("black"))
                .isEqualTo(new Pawn(Color.BLACK));
    }
}