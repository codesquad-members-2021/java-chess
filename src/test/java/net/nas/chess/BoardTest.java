package net.nas.chess;

import net.nas.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static net.nas.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {
    private Board board;
    private static final String INITIAL_STATE_OF_BOARD = appendNewLine("........") +
            appendNewLine("PPPPPPPP") +
            appendNewLine("........") +
            appendNewLine("........") +
            appendNewLine("........") +
            appendNewLine("........") +
            appendNewLine("pppppppp") +
            appendNewLine("........");

    @BeforeEach
    void createTestBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 보드에 폰을 추가하고, 찾을 수 있어야 합니다.")
    void testAdditionAndFind() {
        Pawn whitePawn = new Pawn();
        for (int i = 1; i <= Board.LENGTH_OF_BOARD; i++) {
            final int fileIdx = i;
            assertAll(
                    () -> verifyAddition(whitePawn, Board.RANK_OF_WHITE_PAWNS, fileIdx),
                    () -> verifyFind(whitePawn, Board.RANK_OF_WHITE_PAWNS, fileIdx)
            );
        }
    }

    private void verifyAddition(Pawn pawn, int rankIdx, int fileIdx) {
        int prevSize = board.size();
        board.add(pawn, rankIdx, fileIdx);
        assertThat(board.size()).isEqualTo(prevSize + 1);
    }

    private void verifyFind(Pawn pawn, int rankIdx, int fileIdx) {
        assertThat(board.findPawn(rankIdx, fileIdx)).isEqualTo(pawn);
    }

    @Test
    @DisplayName("폰을 찾을때 넣는 인덱스가 배열의 범위를 벗어나면 예외가 발생해야 합니다")
    void testErrorFind() {
        int[] testcases = {-1, 0, Board.LENGTH_OF_BOARD + 1};
        for (int tc : testcases)
            testFindThrowException(tc, tc, InvalidParameterException.class);
    }

    private void testFindThrowException(int rankIdx, int fileIdx, Class<?> exceptionClass) {
        assertThatThrownBy(() -> board.findPawn(rankIdx, fileIdx))
                .isInstanceOf(exceptionClass);
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

    private void testAdditionThrowException(Object tc, Class<?> exceptionClass) {
        assertThatThrownBy(() -> board.add((Pawn) tc, 1, 1))
                .isInstanceOf(exceptionClass);
    }

    @Test
    @DisplayName("초기화 후에는 흰색폰과 검정색폰이 각각 랭크 2, 7에 한줄씩 배치되어야 합니다.")
    void testInitialization() {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
        assertThat(board.size()).isEqualTo(16);
    }

    @Test
    @DisplayName("체스보드에서 폰만 초기화하고 나서, 적절한 결과를 획득할 수 있어야 합니다")
    void testPrintBoard() {
        board.initialize();
        assertThat(board.getRepresentationOfBoard()).isEqualTo(INITIAL_STATE_OF_BOARD);
    }

}
