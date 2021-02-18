package net.tree.chess;

import net.tree.pieces.Pawn;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;


public class BoardTest {

    @DisplayName("하얀색, 검정색 pawn 만들기")
    @Test
    public void create() {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        Assertions.assertAll(
            () -> assertEquals(1, board.checkPawnSize()),
            () -> assertEquals(white, board.findPawn(0))
        );

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        Assertions.assertAll(
                () -> assertEquals(2, board.checkPawnSize()),
                () -> assertEquals(black, board.findPawn(1))
        );
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

    @DisplayName("pawnList 확인해보기 ")
    @Test
    public void checkPawnList() {
        Board board = new Board();
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white);
        assertEquals(1, board.checkPawnSize());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.checkPawnSize());
        assertEquals(black, board.findPawn(1));

    }
}
