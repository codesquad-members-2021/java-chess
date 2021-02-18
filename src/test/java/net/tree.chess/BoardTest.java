package net.tree.chess;

import net.tree.pieces.Pawn;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BoardTest {

    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));


        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));

    }

    @DisplayName("컴파일 에러 발생시키기")
    @Test
    public void checkPawnList() throws Exception {
        Board board = new Board();
        //assertTrue(board.pawnList.add("7"));
        assertTrue(board.pawnList.add(new Pawn()));
    }

    @DisplayName("보드 초기화 및 그리기")
    @Test
    public void initializeBoardAndPrint() throws Exception {
        Board board = new Board();
        board.initialize();
        board.print();
    }

    @Test
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getPawnsResult(Pawn.WHITE_REPRESENTATION));
        assertEquals("PPPPPPPP", board.getPawnsResult(Pawn.BLACK_REPRESENTATION));
    }
}
