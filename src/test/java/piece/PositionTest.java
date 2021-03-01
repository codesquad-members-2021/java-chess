package piece;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {
    @Test
    @DisplayName("Verify Position is correctly created")
    void create() {
        Position position = new Position("a1");
        assertAll(
                () -> assertThat(position.getX()).isEqualTo(1),
                () -> assertThat(position.getY()).isEqualTo(1),
                () -> assertThat(position.getXIndex()).isEqualTo(0),
                () -> assertThat(position.getYIndex()).isEqualTo(0)
        );
    }
}
