package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BishopTest {
    @Test
    @DisplayName("흰색 Bishop 의 representation 은 b여야 한다.")
    void getRepresentation_white() {
        String actual = Bishop.of(Color.WHITE)
                .getRepresentation();
        assertThat(actual)
                .isEqualTo("b");
    }

    @Test
    @DisplayName("까만 Bishop 의 representation 은 B여야 한다.")
    void getRepresentation_black() {
        String actual = Bishop.of(Color.BLACK)
                .getRepresentation();
        assertThat(actual)
                .isEqualTo("B");
    }
}
