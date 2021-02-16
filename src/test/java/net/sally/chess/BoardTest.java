package net.sally.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sally.pieces.Pawn;

public class BoardTest {

    private Board board;
    private Pawn whitePawn, blackPawn;

    @BeforeEach
    void setUp() {
        board = new Board();
        whitePawn = new Pawn(Pawn.WHITE, Pawn.WHITE_REPRESENTATION);
        blackPawn = new Pawn(Pawn.BLACK, Pawn.BLACK_REPRESENTATION);
    }

    @Test
    @DisplayName("폰이 보드에 정상적으로 등록")
    void create() throws Exception {
        verifyWhitePawns(board, whitePawn, 0);
        verifyBlackPawns(board, blackPawn, 0);
    }

    private void verifyWhitePawns(Board board, Pawn pawn, int size) {
        board.addWhitePawn(pawn);
        assertAll(
                () -> assertThat(board.getWhitePawnSize()).isEqualTo(size + 1),
                () -> assertThat(board.findWhitePawn(size)).isEqualTo(pawn)
        );
    }

    private void verifyBlackPawns(Board board, Pawn pawn, int size) {
        board.addBlackPawn(pawn);
        assertAll(
                () -> assertThat(board.getBlackPawnsSize()).isEqualTo(size + 1),
                () -> assertThat(board.findBlackPawn(size)).isEqualTo(pawn)
        );
    }

    @Test
    @DisplayName("보드가 정상적으로 출력")
    void printer() {
        board.initialize();
        board.print();
    }

    @Test
    void initialize() {
        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }
}
