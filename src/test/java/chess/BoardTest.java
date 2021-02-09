package chess;

import org.junit.jupiter.api.*;
import pieces.Pawn;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("폰이 제대로 추가되었는지 검증한다.")
    public void create() {
        verifyAdd(board, new Pawn(Color.WHITE), 1);
        verifyAdd(board, new Pawn(Color.BLACK), 2);
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