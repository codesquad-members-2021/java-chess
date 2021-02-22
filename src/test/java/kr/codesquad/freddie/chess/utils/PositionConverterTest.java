package kr.codesquad.freddie.chess.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionConverterTest {
    @Test
    void create_outOfRange() {
        assertThatThrownBy(()->PositionConverter.createBy("01"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. position : 01");
        assertThatThrownBy(()->PositionConverter.createBy("i1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. position : i1");
        assertThatThrownBy(()->PositionConverter.createBy("a0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. position : a0");
        assertThatThrownBy(()->PositionConverter.createBy("a9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. position : a9");
    }

    @Test
    void getFileIndex() {
        assertThat(PositionConverter.createBy("a1").getFileIndex()).isEqualTo('a');
        assertThat(PositionConverter.createBy("h1").getFileIndex()).isEqualTo('h');
    }

    @Test
    void getRankIndex() {
        assertThat(PositionConverter.createBy("a1").getRankIndex()).isEqualTo(1);
        assertThat(PositionConverter.createBy("a8").getRankIndex()).isEqualTo(8);
    }

    @Test
    void getFileIndexForList() {
        assertThat(PositionConverter.createBy("a1").getFileIndexForList()).isEqualTo(0);
        assertThat(PositionConverter.createBy("h1").getFileIndexForList()).isEqualTo(7);
    }

    @Test
    void getRankIndexForList() {
        assertThat(PositionConverter.createBy("a1").getRankIndexForList()).isEqualTo(7);
        assertThat(PositionConverter.createBy("a8").getRankIndexForList()).isEqualTo(0);
    }
}
