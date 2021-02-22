package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class KingTest {
    @Test
    @DisplayName("흰색 King 의 representation 은 k여야 한다.")
    void getRepresentation_white() {
        String actual = King.of(Color.WHITE)
                .toString();
        assertThat(actual)
                .isEqualTo("k");
    }

    @Test
    @DisplayName("까만 King 의 representation 은 K여야 한다.")
    void getRepresentation_black() {
        String actual = King.of(Color.BLACK)
                .toString();
        assertThat(actual)
                .isEqualTo("K");
    }
}
