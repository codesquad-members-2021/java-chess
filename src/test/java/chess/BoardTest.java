package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Verify Board initialize and toString")
    public void create() {
        board.initialize();
        assertThat(board.sizeofPiece()).isEqualTo(32);

        final String BLANK_LINE = appendNewLine("........");
        assertThat(board.toString())
                .isEqualTo(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        BLANK_LINE + BLANK_LINE + BLANK_LINE + BLANK_LINE +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
                );

    }
}
