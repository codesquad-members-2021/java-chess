package kr.codesquad.freddie.chess.utils;

import kr.codesquad.freddie.chess.board.RankIndex;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankIndexTest {
    @Test
    void create_outOfRange() {
        assertThatThrownBy(() -> new RankIndex(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 0");
        assertThatThrownBy(() -> new RankIndex(9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 9");
    }

    @Test
    void getRankIndex() {
        assertThat(new RankIndex(1).getRankIndex()).isEqualTo(1);
        assertThat(new RankIndex(8).getRankIndex()).isEqualTo(8);
    }

    @Test
    void getRankIndexForList() {
        assertThat(new RankIndex(1).getRankIndexForList()).isEqualTo(7);
        assertThat(new RankIndex(8).getRankIndexForList()).isEqualTo(0);
    }
}
