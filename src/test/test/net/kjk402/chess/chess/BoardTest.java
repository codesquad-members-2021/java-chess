package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void init(){
        board = new Board();
    }

    @Test
    @DisplayName("흰색폰 넣은 다음 검은색폰을 넣는다.")
    public void create(){
        verifyBoard(Pawn.WHITE, 1, 0);
        verifyBoard(Pawn.BLACK,2,1);
    }

    void verifyBoard(String color,int expectedSize ,int idx){
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(expectedSize, board.size());
        assertEquals(pawn, board.findPwan(idx));
    }
}