package net.honux.chess.util;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {

    @Test
    void appendNewLine() {
        StringBuilder sb = new StringBuilder();
        StringUtils.appendNewLine(sb, "test");
        assertThat(StringUtils.convertString(sb)).isEqualTo("test"+StringUtils.NEWLINE);
    }
}
