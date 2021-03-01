package net.jung.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    @DisplayName("동일한 위치의 positon은 서로 같다")
    void checkEquals() {
        assertThat(Position.createPosition("a7")).isEqualTo(Position.createPosition("a7"));
    }
}
