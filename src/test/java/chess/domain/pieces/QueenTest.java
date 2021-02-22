package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QueenTest {
    @Test
    @DisplayName("흰색 Queen 의 representation 은 q여야 한다.")
    void getRepresentation_white() {
        String actual = Queen.of(Color.WHITE)
                .toString();
        assertThat(actual)
                .isEqualTo("q");
    }

    @Test
    @DisplayName("까만 Queen 의 representation 은 Q여야 한다.")
    void getRepresentation_black() {
        String actual = Queen.of(Color.BLACK)
                .toString();
        assertThat(actual)
                .isEqualTo("Q");
    }
}
