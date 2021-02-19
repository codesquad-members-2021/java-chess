package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static utils.StringUtils.appendNewLine;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {
    @Test
    @DisplayName("문자열에 개행을 추가한다")
    void appendNewLineTest() {
        String text = "text";
        assertThat(appendNewLine(text)).isEqualTo(text + StringUtils.NEW_LINE);
    }
}
