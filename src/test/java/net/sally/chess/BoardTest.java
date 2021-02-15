package net.sally.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import net.sally.pieces.Pawn;

public class BoardTest {

    private Board board;
    private Pawn whitePawn, blackPawn;

    @BeforeEach
    private void setUp() {
        board = new Board();
        whitePawn = new Pawn(Pawn.WHITE);
        blackPawn = new Pawn(Pawn.BLACK);
    }

    @Test
    @DisplayName("폰이 보드에 정상적으로 등록")
    void create() throws Exception {
        verifyBoard(board, whitePawn, 0);
        verifyBoard(board, blackPawn, 1);
    }

    private void verifyBoard(Board board, Pawn pawn, int index) {
        board.addPawn(pawn);
        assertThat(board.getPawnSize()).isEqualTo(index + 1);
        assertThat(board.findPawn(index)).isEqualTo(pawn);
    }
}
