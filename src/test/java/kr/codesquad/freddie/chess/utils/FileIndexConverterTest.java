package kr.codesquad.freddie.chess.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FileIndexConverterTest {
    @Test
    void create_outOfRange() {
        assertThatThrownBy(() -> new FileIndexConverter((char) ('a' - 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : `");
        assertThatThrownBy(() -> new FileIndexConverter('i'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 fileIndex가 아닙니다. fileIndex : i");
    }

    @Test
    void getFileIndex() {
        assertThat(new FileIndexConverter('a').getFileIndex()).isEqualTo('a');
        assertThat(new FileIndexConverter('h').getFileIndex()).isEqualTo('h');
    }

    @Test
    void getFileIndexForList() {
        assertThat(new FileIndexConverter('a').getFileIndexForList()).isEqualTo(0);
        assertThat(new FileIndexConverter('h').getFileIndexForList()).isEqualTo(7);
    }
}
