package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import pieces.Piece;
import static utils.StringUtils.appendNewLine;

class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard(){
        board = new Board();
    }

    @Test
    @DisplayName("보드판 출력이 원하는 그림대로 나오는지 테스트")
    public void showPieceNumAndTotalBoard(){
        board.initialize();
        assertThat(32).isEqualTo(board.pieceCount());
        String blankArea = appendNewLine("........");
        assertThat(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankArea + blankArea + blankArea + blankArea +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr")
        ).isEqualTo(board.getBoard());
    }
}
