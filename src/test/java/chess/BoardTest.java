package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("piece의 갯수를 정확히 세는지 테스트")
    void showPieceNum() {
        board.initialize();
        assertThat(board.sizeOfPieces()).isEqualTo(32);
    }

    @Test
    @DisplayName("보드판 출력이 원하는 그림대로 나오는지 테스트")
    void showTotalBoard() {
        board.initialize();
        String blankArea = appendNewLine("........");
        assertThat(board.bringBoard()).isEqualTo(
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankArea + blankArea + blankArea + blankArea +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
        );
    }
}
