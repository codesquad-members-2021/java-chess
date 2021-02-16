package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("board.initialize를 사용하여 생성된 흰색폰과 검은색폰들의 결과를 확인한다.")
    void initialize() {
        board.initialize();
        assertAll(
                () -> assertEquals("pppppppp", board.getWhitePawnsResult()),
                () -> assertEquals("PPPPPPPP", board.getBlackPawnsResult())
        );
    }

}
