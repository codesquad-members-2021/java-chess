package net.woody.chess;

import net.woody.pieces.Piece;
import net.woody.pieces.Color;
import org.junit.jupiter.api.*;

import static net.woody.utils.StringUtils.appendNewLine;
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
        Piece firstPiece = Piece.createWhitePawn();
        addThePawnProperly(firstPiece, 0);

        Piece secondPiece = Piece.createWhitePawn();
        addThePawnProperly(secondPiece, 1);
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
        // TODO : 메소드 명 상세하게
    void initialize() {
        board.initialize();
        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("보드를 초기화 한 뒤 출력된 결과가 예상된 결과와 같아야 한다.")
        // TODO : 메소드 명 상세하게
    void print() {
        board.initialize();
        String expectedResult =
                appendNewLine("........") +
                        appendNewLine("PPPPPPPP") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("pppppppp") +
                        appendNewLine("........");

        String actualResult = board.print();
        assertThat(expectedResult).isEqualTo(actualResult);
    }

    private void addThePawnProperly(Piece newPiece, int newPawnIdx) {
        int rank = getPawnRank(newPiece);
        int sizeBeforeAddThePawn = board.size();
        board.add(newPiece);
        assertThat(sizeBeforeAddThePawn + 1).isEqualTo(board.size());
        assertThat(newPiece).isEqualTo(board.findPawn(rank, newPawnIdx));
    }

    private int getPawnRank(Piece newPiece) {
        return (newPiece.getColor() == Color.WHITE) ? Piece.WHITE_PAWN_RANK : Piece.BLACK_PAWN_RANK;
    }
}
