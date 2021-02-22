package net.honux.chess.util;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;
import static net.honux.chess.util.StringUtils.*;

public class StringUtilsTest {

    @Test
    void appendNewLineTest() {
        StringBuilder sb = new StringBuilder();
        appendNewLine(sb, "test");
        assertThat(convertString(sb)).isEqualTo("test" + NEWLINE);
    }
}
