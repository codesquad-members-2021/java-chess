package net.tree.chess;

import net.tree.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board board;

    @BeforeEach
    void makeNewBoard() {
        board = new Board();
    }

    @DisplayName("하얀색, 검정색 pawn 만들기")
    @Test
    public void create() {
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
    public void initializeBoardAndPrint() {
        board.initialize();
        board.print();
    }

    @DisplayName("보드 초기화하기")
    @Test
    public void initialize() {
        board.initialize();
        assertEquals("pppppppp", board.getPawnsResult(Pawn.WHITE_REPRESENTATION));
        assertEquals("PPPPPPPP", board.getPawnsResult(Pawn.BLACK_REPRESENTATION));
    }

    @DisplayName("pawnList 확인해보기 ")
    @Test
    public void checkPawnList() {
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
