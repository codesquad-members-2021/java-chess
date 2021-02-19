package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    void create_white() {
        verifyPawn(Color.WHITE);
    }

    @Test
    @DisplayName("까만 폰이 생성되어야 한다")
    void create_black() {
        verifyPawn(Color.BLACK);
    }

    private void verifyPawn(Color color) {
        assertThat(Pawn.of(color).getColor())
                .isEqualTo(color);
    }

    @Test
    @DisplayName("흰색 폰의 representation 은 소문자여야 한다.")
    void getRepresentation_white() {
        assertThat(Pawn.of(Color.WHITE).getRepresentation())
                .isEqualTo("p");
    }

    @Test
    @DisplayName("까만 폰의 representation 은 대문자여야 한다.")
    void getRepresentation_black() {
        assertThat(Pawn.of(Color.BLACK).getRepresentation())
                .isEqualTo("P");
    }
} 
