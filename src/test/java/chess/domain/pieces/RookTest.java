package chess.domain.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RookTest {
    @Test
    @DisplayName("흰색 Rook 의 representation 은 r여야 한다.")
    void getRepresentation_white() {
        assertThat(Rook.ofWhite().toString())
                .isEqualTo("r");
    }

    @Test
    @DisplayName("까만 Rook 의 representation 은 R여야 한다.")
    void getRepresentation_black() {
        assertThat(Rook.ofBlack().toString())
                .isEqualTo("R");
    }
}
