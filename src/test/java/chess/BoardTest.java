package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.appendNewLine;


class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("초기화 했을 때 Board에 모든 기물이 제대로 올라가는지 확인")
    void initialize() {
        assertAll(
                () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
                () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP"),
                () -> assertThat(board.getWhitePiecesResult()).isEqualTo("rnbqkbnr"),
                () -> assertThat(board.getBlackPiecesResult()).isEqualTo("RNBQKBNR")
        );
    }

    @Test
    @DisplayName("초기화 했을때 Board출력이 제대로 되는지 확인")
    void print() {
        String empty = appendNewLine("........");
        assertThat(board.printBoard()).isEqualTo(
                        appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        empty + empty + empty + empty +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"));
    }
    @Test
    @DisplayName("초기화 하면 32개의 기물이 올라가는지 확인")
    void size(){
        assertThat(board.size()).isEqualTo(32);
    }
}
