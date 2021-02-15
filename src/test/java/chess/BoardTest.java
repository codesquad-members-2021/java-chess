package chess;

import org.junit.jupiter.api.*;
import pieces.Pawn;
import pieces.Pawn.Color;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판이 제대로 초기화되었는지 검증한다")
    void initialize() {
        board.initialize();
        assertAll(() -> assertThat(board.getWhitePawnsToPrint()).isEqualTo("pppppppp"),
                () -> assertThat(board.getBlackPawnsToPrint()).isEqualTo("PPPPPPPP"));
    }

    @Test
    @DisplayName("폰이 제대로 추가되었는지 검증한다")
    void verifyAdd() {
        assertAll(() -> verifyAddWhitePawn(new Pawn(Color.WHITE), 1),
                () -> verifyAddBlackPawn(new Pawn(Color.BLACK), 2),
                () -> verifyAddBlackPawn(new Pawn(Color.BLACK), 3));
    }

    void verifyAddWhitePawn(Pawn pawn, int size) {
        board.addWhitePawn(pawn);
        assertAll(() -> assertThat(board.size()).isEqualTo(size),
                () -> assertThat(board.findWhitePawn(size - 1 - board.blackPawnsSize())).isEqualTo(pawn));
    }

    void verifyAddBlackPawn(Pawn pawn, int size) {
        board.addBlackPawn(pawn);
        assertAll(() -> assertThat(board.size()).isEqualTo(size),
                () -> assertThat(board.findBlackPawn(size - 1 - board.whitePawnsSize())).isEqualTo(pawn));
    }

    @Test
    void print() {
        board.initialize();
        board.print();
    }

}


