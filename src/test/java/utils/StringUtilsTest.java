package utils;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static utils.StringUtils.*;

class StringUtilsTest {

    @Test
    @DisplayName("문자열에 8자 단위로 개행문자를 추가해야 한다")
    void verifyAppendNewLine() {
        String blackPieces = "RNBQKBNRPPPPPPPP";
        String result = appendNewLine(blackPieces);
        assertThat(result).isEqualTo("RNBQKBNR" + NEWLINE + "PPPPPPPP" + NEWLINE);
    }
}
