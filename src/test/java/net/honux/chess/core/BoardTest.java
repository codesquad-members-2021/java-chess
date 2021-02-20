package net.honux.chess.core;

import net.honux.chess.util.StringUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static net.honux.chess.util.StringUtils.*;

class BoardTest {

    Board board;

    @BeforeEach
    void generateBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("흰색 Pices 16개 블랙 Pices 16개가 정상적으로 initialize() 를 통해서 생성되는지 확인한다.")
    void checkPawnCount() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat(board.whitePawnSize()).isEqualTo(Board.BOARD_SIZE * 2),
                () -> assertThat(board.blackPawnSize()).isEqualTo(Board.BOARD_SIZE * 2));
    }

    @Test
    @DisplayName("보드에 올려진 출력 메세지가 정상적으로 리턴되는지 확인한다.")
    void checkBoardPrintMessage() {
        board.initialize();
        String expectedMessage =
                "RNBQKBNR" + NEWLINE +
                "PPPPPPPP" + NEWLINE +
                "********" + NEWLINE +
                "********" + NEWLINE +
                "********" + NEWLINE +
                "********" + NEWLINE +
                "pppppppp" + NEWLINE +
                "rnbqkbnr" + NEWLINE ;
        assertThat(board.getBoardStatusToString()).isEqualTo(expectedMessage);
        // TestCode 에서 출력 해달라는 요구사항 을 만족시키기 위해 작성
        board.print();
    }
}
