package net.kjk402.chess.chess;

import net.kjk402.chess.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("흰색폰 넣은다음 검은색폰을 넣는다.")
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPwan(0));

        Pawn black = new Pawn(Pawn.BLACK);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPwan(1));
    }

}