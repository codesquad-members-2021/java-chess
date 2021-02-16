package chess;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import pieces.Pawn;

class BoardTest {
    @Test
    @DisplayName("체스판에 흰색, 검은색 폰을 추가하고 갯수와 목록을 확인한다.")
    void putPawn(){
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("폰 이외의 객체를 추가하면 컴파일 에러가 발생한다")
    void putOther(){
        Board board = new Board();
        int num7 = new Integer(7);
        //board.add(num7);
    }
}