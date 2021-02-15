package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    @DisplayName("보드에 흰색폰과 검정폰을 차례로 넣고 보드의 사이즈와 폰의 위치를 확인.")
    void createBoard() {
        verifyBoard(Pawn.WHITE, 1, 0);
        verifyBoard(Pawn.BLACK, 2, 1);
    }

    private void verifyBoard(String color, int expectedSize, int idx) {
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertAll(
                () -> assertEquals(expectedSize, board.size()),
                () -> assertEquals(pawn, board.findPwan(idx))
        );
    }
}
