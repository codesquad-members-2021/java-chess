package net.honux.chess;

import net.honux.pieces.Pawn;
import org.junit.jupiter.api.*;

public class BoardTest {

    @Test
    @DisplayName("생성된 보드 위에 폰 추가, 폰 갯수 확인, 특정 폰 찾기가 가능해야 한다.")
    void create_보드생성과_폰추가() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        Assertions.assertEquals(1, board.size());
        Assertions.assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        Assertions.assertEquals(2, board.size());
        Assertions.assertEquals(black, board.findPawn(1));
    }


    @Test
    @DisplayName("폰이 아닌 객체를 Board에 추가할 시 에러가 발생해야 한다.")
    void add_보드위에_폰이_아닌_객체추가() {
        Board board = new Board();

        Object notPawn = new Object();
        board.add(notPawn);
    }
}
