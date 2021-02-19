package net.eno.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

import net.eno.pieces.Color;
import static net.eno.utils.StringUtils.appendNewLine;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("초기화 된 보드의 말의 개수가 32개여야 한다.")
    public void size() {
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("초기화 된 보드의 말의 배치가 일치해야 한다.")
    public void initialize() {
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard(Color.WHITE)).isEqualTo(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr")
        );

        assertThat(board.showBoard(Color.BLACK)).isEqualTo(
                appendNewLine("rnbkqbnr") +
                appendNewLine("pppppppp") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("PPPPPPPP") +
                appendNewLine("RNBKQBNR")
        );
    }

    @Test
    @DisplayName("초기화 된 보드가 출력되어야 한다.")
    public void print() {
        System.out.println(board.showBoard(Color.WHITE));
        System.out.println();
        System.out.println(board.showBoard(Color.BLACK));
    }

}
