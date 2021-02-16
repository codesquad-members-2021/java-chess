package net.sally.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import net.sally.pieces.Pawn;

public class BoardTest {

    private Board board;
    private Pawn whitePawn, blackPawn;

    @BeforeEach
    private void setUp() {
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

    private void verifyWhitePawns(Board board, Pawn pawn, int index) {
        board.addWhitePawn(pawn);
        assertAll(
                () -> assertThat(board.getWhitePawnSize()).isEqualTo(index + 1),
                () -> assertThat(board.findWhitePawn(index)).isEqualTo(pawn)
        );
    }

    private void verifyBlackPawns(Board board, Pawn pawn, int index) {
        board.addBlackPawn(pawn);
        assertAll(
                () -> assertThat(board.getBlackPawnsSize()).isEqualTo(index + 1),
                () -> assertThat(board.findBlackPawn(index)).isEqualTo(pawn)
        );
    }

    @Test
    @DisplayName("Prints properly")
    void printer() {
        board.initialize();
        board.print();
    }

    @Test
    @DisplayName("Board initializes properly")
    void initialize() throws Exception {
        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }
}
