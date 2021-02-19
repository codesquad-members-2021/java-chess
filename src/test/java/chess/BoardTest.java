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
        Pawn white = new Pawn();
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);
    }

    @Test
    @DisplayName("체스판에 검은색 폰을 추가 후 갯수와 목록을 확인한다.")
    void putBlackPawn() {
        Pawn black = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
        board.add(black);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(black);
    }

    @Test
    @DisplayName("폰 이외의 객체를 추가하면 컴파일 에러가 발생한다")
    void putOther() {
        int num7 = new Integer(7);
        //board.add(num7);
    }
}