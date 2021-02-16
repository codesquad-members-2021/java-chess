package chess;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import pieces.Pawn;

class BoardTest {
    Board board;

    @BeforeEach
    void setBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판에 흰색 폰을 추가 후 갯수와 목록을 확인한다.")
    void putWhitePawn() {
        Pawn white = new Pawn(Pawn.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));
    }

    @Test
    @DisplayName("체스판에 검은색 폰을 추가 후 갯수와 목록을 확인한다.")
    void putBlackPawn() {
        Pawn black = new Pawn(Pawn.BLACK);
        board.add(black);
        assertEquals(1, board.size());
        assertEquals(black, board.findPawn(0));
    }

    @Test
    @DisplayName("폰 이외의 객체를 추가하면 컴파일 에러가 발생한다")
    void putOther() {
        int num7 = new Integer(7);
        //board.add(num7);
    }
}