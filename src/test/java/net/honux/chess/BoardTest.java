package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    @DisplayName("모든 Test 전에 Board 객체 생성")
    void create_Board() {
        board = new Board();
    }

    @Test
    @DisplayName("생성되는 Pawn 객체마다 Board에서 List Size 값 및 index로 색상 값을 잘 가져오는지 확인")
    void create() throws Exception {
        verifyBoard(new Pawn("white"), 1, 0);
        verifyBoard(new Pawn("black"), 2, 1);
    }

    private void verifyBoard(Pawn pawn, int size, int index) {
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(board.findPawn(index)).isEqualTo(pawn);
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}
