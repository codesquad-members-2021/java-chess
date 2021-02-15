package net.Dong;
import net.Dong.chess.Board;
import net.Dong.chess.Pawn;
import org.junit.jupiter.api.Test;
//import org.junit.;
import static org.junit.jupiter.api.Assertions.*;

import net.Dong.chess.Pawn.*;


class BoardTest {


    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Color.WHITE);
        board.whiteAdd(white);
        assertEquals(1, board.size());
        assertEquals(Color.WHITE, board.findPawn(0));

        Pawn black = new Pawn(Color.BALCK);
        board.blackAdd(black);
        assertEquals(2, board.size());
        assertEquals(Color.BALCK, board.findPawn(1));
    }


    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}