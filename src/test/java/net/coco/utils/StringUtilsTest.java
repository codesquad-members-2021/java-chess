package net.coco.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class StringUtilsTest {

    @Test
    void appendNewLine() {
        String line = "line";
        String result = StringUtils.appendNewLine(line);
        assertThat(line + StringUtils.NEWLINE).isEqualTo(result);
    }

}
