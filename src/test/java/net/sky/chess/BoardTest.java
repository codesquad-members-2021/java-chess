package net.sky.chess;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {

    Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 초기화 테스트")
    void initializeBoard() throws Exception {
        board.initialize();
        assertAll(
            () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
            () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }

    @Test
    void printBoard() {
        board.initialize();
        board.print();
    }

}
