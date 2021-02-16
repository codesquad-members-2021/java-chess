package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static utils.StringUtils.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판이 제대로 초기화되었는지 검증한다")
    void verifyInitialize() {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertAll(() -> assertThat(board.numberOfPieces()).isEqualTo(32),
                () -> assertThat(appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")).isEqualTo(board.getResultToPrint()));
    }
}

