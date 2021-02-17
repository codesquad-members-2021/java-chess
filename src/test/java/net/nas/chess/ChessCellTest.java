package net.nas.chess;

import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ChessCellTest {
    private ChessCell cell;

    @BeforeEach
    void initTestcase() {
        cell = new ChessCell();
    }

    @Test
    @DisplayName("체스보드의 셀에 들어간 체스말의 대표문자를 알아낼 수 있어야 합니다.")
    void testGetRepresentation() {
        verifyOccupyMethod(new Pawn(), Pawn.WHITE_REPRESENTATION);
        verifyOccupyMethod(new Pawn(ColorOfChessPiece.BLACK), Pawn.BLACK_REPRESENTATION);
        verifyOccupyMethod(null, ChessCell.NONE_REPRESENTATION);
    }

    private void verifyOccupyMethod(Pawn pawn, char expectedColor) {
        ChessCell chessCell = new ChessCell();
        chessCell.occupy(pawn);
        assertThat(chessCell.getRepresentation()).isEqualTo(expectedColor);
    }

    @Test
    @DisplayName("이미 다른 체스말이 들어간 셀에 다른 체스말이 들어가려고 시도하면, 예외가 발생해야 합니다.")
    void testSetPieceInToAlreadyOccupied() {
        assertThatThrownBy(() -> {
            cell.occupy(new Pawn());
            cell.occupy(new Pawn(ColorOfChessPiece.BLACK));
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("셀에 체스말 외의 객체를 넣으려고 시도하면 예외가 발생해야 합니다.")
    void testErrorOccupy() {
        Object[] testcases = {
                new Object(),
                7,
                "INVALID"
        };
        for (Object tc : testcases)
            testOccupyThrowException(tc, ClassCastException.class);
    }

    private void testOccupyThrowException(Object testcase, Class<?> exceptionClass) {
        assertThatThrownBy(() -> cell.occupy((Pawn) testcase))
                .isInstanceOf(exceptionClass);
    }
}