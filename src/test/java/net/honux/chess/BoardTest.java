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
        verifyBoard(new Pawn(Pawn.WHITE_COLOR,Pawn.WHITE_REPRESENTATION), 1, 0);
        verifyBoard(new Pawn(Pawn.BLACK_COLOR,Pawn.BLACK_REPRESENTATION), 2, 1);
    }

    private void verifyBoard(Pawn pawn, int size, int index) {
        board.add(pawn);
        assertThat(board.size()).isEqualTo(size);
        assertThat(board.findPawn(index)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("보드 초기화가 잘 이루어지는지 확인 예)흰색 ->pppppppp 검은색->PPPPPPPP")
    void initialize() throws Exception {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

}
