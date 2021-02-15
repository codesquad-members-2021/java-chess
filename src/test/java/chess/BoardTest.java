package chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("Board에 Pawn이 제대로 추가되는지 확인")
    void create(){

        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(white, board.find(0));
        assertEquals(1, board.size());

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(black, board.find(1));
        assertEquals(2,board.size());
    }
}