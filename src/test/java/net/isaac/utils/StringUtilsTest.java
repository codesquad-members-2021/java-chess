package net.isaac.utils;

import org.junit.jupiter.api.*;

import static net.isaac.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.*;

class StringUtilsTest {
    @Test
    @DisplayName("appendNewLine 테스트")
    void appendNewLineTest(){
        String string = "New line should be appended";
        assertThat(appendNewLine(string)).isEqualTo(string+System.lineSeparator());
    }
}
