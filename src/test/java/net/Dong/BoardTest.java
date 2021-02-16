package net.Dong;
import net.Dong.chess.Board;
import net.Dong.chess.Pawn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.;
import static org.junit.jupiter.api.Assertions.*;

import net.Dong.chess.Pawn.*;


class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }



    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Color.WHITE);
        board.whiteAdd(white);
        assertEquals(1, board.size());
        assertEquals(Color.WHITE, board.findWhitePawn(0).getColor());

        Pawn black = new Pawn(Color.BLACK, Pawn.BLACK_REPRESENTATION);
        board.blackAdd(black);
        assertEquals(2, board.size());
        assertEquals(Color.BLACK, board.findBlackPawn(0).getColor());
    }


    @Test
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
    @Test
    public void print() throws Exception {
        board.initialize();
        board.print();
    }

}