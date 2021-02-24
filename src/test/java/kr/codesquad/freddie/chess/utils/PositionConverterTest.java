package kr.codesquad.freddie.chess.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionConverterTest {
    @Test
    void create_outOfRange() {
        assertThatThrownBy(()->PositionConverter.of("01"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : 0");
        assertThatThrownBy(()->PositionConverter.of("i1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : i");
        assertThatThrownBy(()->PositionConverter.of("a0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 0");
        assertThatThrownBy(()->PositionConverter.of("a9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 9");
    }

    @Test
    void getFileIndex() {
        assertThat(PositionConverter.of("a1").getFileIndex()).isEqualTo('a');
        assertThat(PositionConverter.of("h1").getFileIndex()).isEqualTo('h');
    }

    @Test
    void getRankIndex() {
        assertThat(PositionConverter.of("a1").getRankIndex()).isEqualTo(1);
        assertThat(PositionConverter.of("a8").getRankIndex()).isEqualTo(8);
    }

    @Test
    void getFileIndexForList() {
        assertThat(PositionConverter.of("a1").getFileIndexForList()).isEqualTo(0);
        assertThat(PositionConverter.of("h1").getFileIndexForList()).isEqualTo(7);
    }

    @Test
    void getRankIndexForList() {
        assertThat(PositionConverter.of("a1").getRankIndexForList()).isEqualTo(7);
        assertThat(PositionConverter.of("a8").getRankIndexForList()).isEqualTo(0);
    }
}
