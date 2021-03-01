package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.board.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {
    @Test
    void createOutOfRange() {
        assertThatThrownBy(()-> Position.of("01"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : 0");
        assertThatThrownBy(()-> Position.of("i1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : i");
        assertThatThrownBy(()-> Position.of("a0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 0");
        assertThatThrownBy(()-> Position.of("a9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 rankIndex가 아닙니다. rankIndex : 9");
    }

    @Test
    void getFileIndex() {
        assertThat(Position.of("a1").getFileIndex()).isEqualTo('a');
        assertThat(Position.of("h1").getFileIndex()).isEqualTo('h');
    }

    @Test
    void getRankIndex() {
        assertThat(Position.of("a1").getRankIndex()).isEqualTo(1);
        assertThat(Position.of("a8").getRankIndex()).isEqualTo(8);
    }

    @Test
    void getFileIndexForList() {
        assertThat(Position.of("a1").getFileIndexForList()).isEqualTo(0);
        assertThat(Position.of("h1").getFileIndexForList()).isEqualTo(7);
    }

    @Test
    void getRankIndexForList() {
        assertThat(Position.of("a1").getRankIndexForList()).isEqualTo(7);
        assertThat(Position.of("a8").getRankIndexForList()).isEqualTo(0);
    }
}
