package net.nas.chess;

import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.Pawn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChessCellTest {
    @Test
    @DisplayName("체스보드의 셀에 들어간 체스말의 대표문자를 알아낼 수 있어야 합니다.")
    void testGetRepresentation() {
        verifyOccupyMethod(new Pawn(), Pawn.WHITE_REPRESENTATION);
        verifyOccupyMethod(new Pawn(ColorOfChessPiece.BLACK), Pawn.BLACK_REPRESENTATION);
        verifyOccupyMethod(null, ChessCell.NONE_REPRESENTATION);
    }

    private void verifyOccupyMethod(Pawn pawn, char expectedColor) {
        ChessCell cell = new ChessCell();
        cell.setOccupiedBy(pawn);
        assertThat(cell.getRepresentation()).isEqualTo(expectedColor);
    }
}