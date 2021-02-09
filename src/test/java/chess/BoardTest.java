package chess;

import org.junit.jupiter.api.*;
import pieces.Pawn;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("폰이 제대로 추가되었는지 검증한다.")
    public void create() {
        Board board = new Board();
        Pawn whitePawn = new Pawn(Color.WHITE);
        Pawn blackPawn = new Pawn(Color.BLACK);

        verifyAdd(board, whitePawn, 1);
        verifyAdd(board, blackPawn, 2);
    }

    public void verifyAdd(Board board, Pawn pawn, int size) {
        board.add(pawn);
        verifySize(board, size);
        verifyFindPawn(board, pawn, size - 1);
    }

    public void verifySize(Board board, int size) {
        assertThat(board.size()).isEqualTo(size);
    }

    public void verifyFindPawn(Board board, Pawn pawn, int index) {
        assertThat(board.findPawn(index)).isEqualTo(pawn);
    }

}