package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PawnTest {
    @Test
    @DisplayName("흰색 Pawn 의 representation 은 p여야 한다.")
    void getRepresentation_white() {
        String actual = Pawn.of(Color.WHITE)
                .toString();
        assertThat(actual)
                .isEqualTo("p");
    }

    @Test
    @DisplayName("까만 Pawn 의 representation 은 P여야 한다.")
    void getRepresentation_black() {
        String actual = Pawn.of(Color.BLACK)
                .toString();
        assertThat(actual)
                .isEqualTo("P");
    }
} 
