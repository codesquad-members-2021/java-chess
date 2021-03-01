package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.board.FileIndex;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FileIndexTest {
    @Test
    void createOutOfRange() {
        assertThatThrownBy(() -> new FileIndex((char) ('a' - 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : `");
        assertThatThrownBy(() -> new FileIndex('i'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : i");
    }

    @Test
    void getFileIndex() {
        assertThat(new FileIndex('a').getFileIndex()).isEqualTo('a');
        assertThat(new FileIndex('h').getFileIndex()).isEqualTo('h');
    }

    @Test
    void getFileIndexForList() {
        assertThat(new FileIndex('a').getFileIndexForList()).isEqualTo(0);
        assertThat(new FileIndex('h').getFileIndexForList()).isEqualTo(7);
    }
}
