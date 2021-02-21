package net.woody.chess;

import net.woody.pieces.Pawn;
import net.woody.pieces.Color;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        this.board = new Board();
    }

    @Test
    @DisplayName("보드에 있는 폰을 정상적으로 찾을 수 있어야 한다.")
    void findPawnOnTheBoard() {
        Pawn firstPawn = new Pawn();
        addThePawnProperly(firstPawn, 0);

        Pawn secondPawn = new Pawn();
        addThePawnProperly(secondPawn, 1);
    }

    @Test
    @DisplayName("보드에 폰이 존재하지 않을 때, 폰을 찾으려고 시도하면 에러가 발생해야 한다.")
    void findPawnNotOnTheBoard() {
        assertThatThrownBy(() -> board.findPawn(0, 0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("0 is out of range!");
    }

    @Test
    @DisplayName("음수 인덱스로 폰을 찾으려고 할 때, 에러가 발생해야 한다.")
    void findPawnWithNegativeIndex() {
        assertThatThrownBy(() -> board.findPawn(-1, 0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("-1 is out of range!");
    }

    @Test
    @DisplayName("보드를 초기화할 때, 폰들이 올바르게 생성되어야 한다.")
    void initialize() {
        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("보드를 초기화 한 뒤 출력된 결과가 예상된 결과와 같아야 한다.")
    void print() {
        board.initialize();
        String expectedResult =
                "........" + System.getProperty("line.separator") +
                        "PPPPPPPP" + System.getProperty("line.separator") +
                        "........" + System.getProperty("line.separator") +
                        "........" + System.getProperty("line.separator") +
                        "........" + System.getProperty("line.separator") +
                        "........" + System.getProperty("line.separator") +
                        "pppppppp" + System.getProperty("line.separator") +
                        "........" + System.getProperty("line.separator");

        String actualResult = board.print();
        assertThat(expectedResult).isEqualTo(actualResult);
        System.out.println(actualResult);
    }

    private void addThePawnProperly(Pawn newPawn, int newPawnIdx) {
        int rank = getPawnRank(newPawn);
        int sizeBeforeAddThePawn = board.size();
        board.add(newPawn);
        assertThat(sizeBeforeAddThePawn + 1).isEqualTo(board.size());
        assertThat(newPawn).isEqualTo(board.findPawn(rank, newPawnIdx));
    }

    private int getPawnRank(Pawn newPawn) {
        return (newPawn.getColor() == Color.WHITE) ? Pawn.WHITE_PAWN_RANK : Pawn.BLACK_PAWN_RANK;
    }
}
