package net.honux.chess;

import net.honux.chess.pieces.Piece;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    @DisplayName("모든 Test 전에 Board 객체 생성")
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("Board에 추가되는 기물 값 검토")
    void check_board_pieceCount() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("보드 초기화가 잘 이루어지는지 확인 예)흰색 ->pppppppp 검은색->PPPPPPPP")
    void initialize() {
        board.initialize();
        assertAll(
                () -> assertEquals("pppppppp",board.getWhitePawnsResult()),
                () -> assertEquals("PPPPPPPP",board.getBlackPawnsResult()),
                () -> assertEquals("rnbqkbnr",board.getWhitePiecesResult()),
                () -> assertEquals("RNBQKBNR",board.getBlackPiecesResult())
        );
    }

    @Test
    @DisplayName("보드 초기화가 잘 print 되는지 확인")
    void show_board() {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr")
        );
    }


}
