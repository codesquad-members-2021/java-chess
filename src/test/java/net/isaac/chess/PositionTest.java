package net.isaac.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class PositionTest {
    @Test
    @DisplayName("Position의 팩토리 메소드 테스트")
    void factoryMethodTest() {
        assertAll(
                () -> verifyPosition(Position.getPosition("a1"), 'a', 1),
                () -> verifyPosition(Position.getPosition("z8"), 'z', 8),
                () -> verifyPosition(Position.getPosition("C4"), 'c', 4),
                () -> assertThat(Position.getPosition("1a")).isNull(),
                () -> assertThat(Position.getPosition("aa")).isNull(),
                () -> assertThat(Position.getPosition("a23")).isNull()
        );
    }

    void verifyPosition(Position position, char file, int rank) {
        assertAll(
                () -> assertThat(position.file).isEqualTo(file),
                () -> assertThat(position.rank).isEqualTo(rank)
        );
    }
}
