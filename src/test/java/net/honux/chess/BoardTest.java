package net.honux.chess;

import net.honux.chess.pieces.Pawn;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    @DisplayName("모든 Test 전에 Board 객체 생성")
    void create_Board() {
        board = new Board();
    }

    @Test
    @DisplayName("생성되는 Pawn 객체마다 Board에서 List Size 값 및 index로 색상 값을 잘 가져오는지 확인")
    public void create() throws Exception {
        verifyBoard(new Pawn("white"), 1, 0);
        verifyBoard(new Pawn("black"), 2, 1);
    }

    void verifyBoard(Pawn pawn, int size, int index) {
        board.add(pawn);
        assertEquals(size, board.size());
        assertEquals(pawn, board.findPawn(index));
    }
}