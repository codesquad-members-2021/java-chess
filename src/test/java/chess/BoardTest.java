package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("Board에 Pawn이 제대로 추가되는지 확인")
    void create() {
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        verifyAddPawn(white,0);
        verifyAddPawn(black,1);
    }

    void verifyAddPawn(Pawn pawn, int index) {
        board.add(pawn);
        assertAll(
                () -> assertEquals(pawn, board.find(index)),
                () -> assertEquals(index+1, board.size())
        );
    }
}
