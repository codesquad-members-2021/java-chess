package chess.domain.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {

    @Test
    @DisplayName("columnId 와 rowId 가 같다면, 같은 Position 이어야 한다.")
    void testEquals() {
        assertThat(new Position('c', 4))
                .isEqualTo(new Position("c4"));
    }

    @Test
    @DisplayName("columnId 와 rowId 가 같다면, hashCode 값도 같아야 한다.")
    void testHashCode() {
        assertThat(new Position('f', 2).hashCode())
                .isEqualTo(new Position("f2").hashCode());
    }
}
