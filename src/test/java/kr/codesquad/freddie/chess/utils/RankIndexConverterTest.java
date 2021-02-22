package kr.codesquad.freddie.chess.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RankIndexConverterTest {
    @Test
    void create_outOfRange() {
        assertThatThrownBy(() -> new RankIndexConverter(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 0");
        assertThatThrownBy(() -> new RankIndexConverter(9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 9");
    }

    @Test
    void getRankIndex() {
        assertThat(new RankIndexConverter(1).getRankIndex()).isEqualTo(1);
        assertThat(new RankIndexConverter(8).getRankIndex()).isEqualTo(8);
    }

    @Test
    void getRankIndexForList() {
        assertThat(new RankIndexConverter(1).getRankIndexForList()).isEqualTo(7);
        assertThat(new RankIndexConverter(8).getRankIndexForList()).isEqualTo(0);
    }
}
