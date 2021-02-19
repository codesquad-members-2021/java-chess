package chess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static utils.StringUtils.*;

class ChessGameTest {

    private final PrintStream stdout = System.out;
    private ByteArrayOutputStream outputStreamCapture;
    private PrintStream ps;

    @BeforeEach
    void beforeEach() {
        outputStreamCapture = new ByteArrayOutputStream();
        ps = new PrintStream(outputStreamCapture);
        System.setOut(ps);
    }

    @AfterEach
    void afterEach() {
        ps.close();
    }

    @Test
    @DisplayName("게임 시작 시 출력 메시지")
    void showStartMessageTest() {
        ChessGame.showStartMessage();
        assertThat(outputStreamCapture.toString())
                .isEqualTo(
                        appendNewLine("체스 게임 시작") +
                        appendNewLine("게임 시작은 start, 종료는 end를 입력하세요"));
    }

    @Test
    @DisplayName("게임 도움말 출력 메시지")
    void helpTest() {
        ChessGame.help();
        assertThat(outputStreamCapture.toString())
                .isEqualTo(
                        appendNewLine("start : 게임 시작") +
                        appendNewLine("end   : 게임 종료") +
                        appendNewLine("help  : 도움말"));
    }
}
