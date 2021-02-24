package pieces;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PositionTest {
    @Test
    @DisplayName("Verify Position is correctly created")
    public void create() {
        Position position = new Position("a1");
        assertAll(
                () -> assertThat(position.getX()).isEqualTo(1),
                () -> assertThat(position.getY()).isEqualTo(1),
                () -> assertThat(position.getXPos()).isEqualTo(0),
                () -> assertThat(position.getYPos()).isEqualTo(0)
        );
    }
}
