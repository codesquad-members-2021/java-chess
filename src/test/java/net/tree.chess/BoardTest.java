package net.tree.chess;

import net.tree.pieces.Pawn;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


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

    @DisplayName("pawnList 확인해보기 ")
    @Test
    public void checkPawnList() {
        Board board = new Board();
        assertTrue(board.pawnList.add(new Pawn()));
    }
}
