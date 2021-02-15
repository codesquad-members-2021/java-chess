package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringUtilsTest {

    @Test
    @DisplayName("문자열 뒤에 줄바꿈 추가")
    void appendNewLineTest() {
        String testString = "테스트";
        assertThat(testString + System.lineSeparator()).isEqualTo(StringUtils.appendNewLine(testString));
    }

    @Test
    @DisplayName("줄바꿈 문자열")
    void newLine() {
        assertThat(System.lineSeparator()).isEqualTo(StringUtils.NEWLINE);
    }
}
