package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class KnightTest {
    @Test
    @DisplayName("흰색 Knight 의 representation 은 n여야 한다.")
    void getRepresentation_white() {
        String actual = Knight.of(Color.WHITE)
                .toString();
        assertThat(actual)
                .isEqualTo("n");
    }

    @Test
    @DisplayName("까만 Knight 의 representation 은 N여야 한다.")
    void getRepresentation_black() {
        String actual = Knight.of(Color.BLACK)
                .toString();
        assertThat(actual)
                .isEqualTo("N");
    }
}
