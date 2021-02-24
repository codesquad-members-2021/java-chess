package net.honux.chess.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static net.honux.chess.utils.StringUtils.appendNewLine;

class StringUtilsTest {

    @Test
    @DisplayName("appendNewLine() 메소드랑 상수 NEWLINE이 제대로 작동하는지 확인한다.")
    void newLineTest() {
        StringBuilder sb = new StringBuilder();
        sb.append(appendNewLine("테스트1"));
        sb.append(appendNewLine("테스트2"));
        sb.append(StringUtils.NEWLINE);
        sb.append("test");
        System.out.print(sb.toString());
    }
}
