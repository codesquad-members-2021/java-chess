package net.honux.chess;

import net.honux.pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        this.board = new Board();
    }

    @Test
    @DisplayName("보드에 있는 폰을 정상적으로 찾을 수 있어야 한다.")
    void findPawnOnTheBoard() {
        Pawn firstPawn = new Pawn();
        addThePawnProperly(firstPawn, 0);

        Pawn secondPawn = new Pawn();
        addThePawnProperly(secondPawn, 1);
    }

    @Test
    @DisplayName("보드에 없는 폰을 찾으려고 할 때, 에러가 발생해야 한다.")
    void findPawnNotOnTheBoard() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.findPawn(0));
    }

    private void addPawn(Pawn newPawn) {
        int sizeBeforeAddThePawn = board.size();
        board.add(newPawn);
        Assertions.assertEquals(sizeBeforeAddThePawn + 1, board.size());
    }

    private void checkTheBoard(Pawn newPawn, int newPawnIdx) {
        Assertions.assertEquals(newPawn, board.findPawn(newPawnIdx));
    }

    private void addThePawnProperly(Pawn newPawn, int newPawnIdx) {
        addPawn(newPawn);
        checkTheBoard(newPawn, newPawnIdx);
    }
}
