package chess;

import net.nas.chess.Board;
import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    Board board;

    @BeforeEach
    void createTestBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드에 폰을 추가하고, 찾을 수 있어야 합니다.")
    void testAdditionAndFind() {
        Pawn[] testcases = {
                new Pawn(),
                new Pawn(ColorOfChessPiece.BLACK)
        };
        for (int i = 0; i < testcases.length; i++) {
            final int idx = i;
            assertAll(
                    () -> verifyAddition(testcases[idx], idx),
                    () -> verifyFind(testcases[idx], idx)
            );
        }
    }

    void verifyAddition(Pawn pawn, int idx) {
        board.add(pawn);
        assertThat(board.size()).isEqualTo(idx + 1);
    }

    void verifyFind(Pawn pawn, int idx) {
        assertThat(board.findPawn(idx)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("Pawn 이외의 객체가 추가되어선 안됩니다.")
    void testErrorAddition() {
        Object[] testcases = {
                new Object(),
                7,
                "Error"
        };
        for (Object tc : testcases)
            assertThatThrownBy(() -> {
                board.add((Pawn) tc);
            }).isInstanceOf(ClassCastException.class);
        assertThatThrownBy(() -> {
            board.add(null);
        }).isInstanceOf(InvalidParameterException.class);
        assertThat(board.size()).isEqualTo(0);
    }
}
