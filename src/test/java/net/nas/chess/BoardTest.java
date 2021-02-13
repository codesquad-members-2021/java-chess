package net.nas.chess;

import net.nas.pieces.ColorOfChessPiece;
import net.nas.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


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

    @Test
    @DisplayName("폰을 찾을때 넣는 인덱스가 배열의 범위를 벗어나면 예외가 발생해야 합니다")
    void testErrorFind() {
        testFindThrowException(-1, InvalidParameterException.class);
        testFindThrowException(0, InvalidParameterException.class);
        for (int i = 0; i < 2; i++) {
            board.add(new Pawn());
            testFindThrowException(i + 1, InvalidParameterException.class);
        }
    }

    void testFindThrowException(int idx, Class<?> exceptionClass) {
        assertThatThrownBy(() -> {
            board.findPawn(idx);
        }).isInstanceOf(exceptionClass);
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
            testAdditionThrowException(tc, ClassCastException.class);
        testAdditionThrowException(null, InvalidParameterException.class);
        assertThat(board.size()).isEqualTo(0);
    }

    void testAdditionThrowException(Object tc, Class<?> exceptionClass) {
        assertThatThrownBy(() -> {
            board.add((Pawn) tc);
        }).isInstanceOf(exceptionClass);
    }
}
