
package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("Board의 초기 기물 배치 확인")
    void create() throws Exception {
        assertThat(board.pieceCount()).isEqualTo(32);

        String blankRank = appendNewLine("********");

        assertThat(appendNewLine("RNBQKBNR")+
                appendNewLine(NEWLINE)+
                appendNewLine("PPPPPPPP")+
                appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                blankRank +appendNewLine(NEWLINE)+
                appendNewLine("pppppppp") +
                appendNewLine(NEWLINE)+
                appendNewLine("rnbqkbnr")).isEqualTo(board.showBoard());

    }

}
