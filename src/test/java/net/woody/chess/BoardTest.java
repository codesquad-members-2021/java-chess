package net.woody.chess;

import net.woody.pieces.Piece;
import org.junit.jupiter.api.*;

import static net.woody.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        this.board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("보드를 초기화한 후, 체스말이 총 32개여야 한다.")
    void checkTheNumberOfPieces() {
        assertThat(board.size()).isEqualTo(32);
    }

    @Test
    @DisplayName("보드에 있는 폰을 정상적으로 찾을 수 있어야 한다.")
    void findPawnOnTheBoard() {
        addThePieceProperly(Piece.createWhitePawn(), 2, 0);
        addThePieceProperly(Piece.createWhiteKing(), 2, 1);
    }

    @Test
    @DisplayName("체스말이 존재하지 않는 위치에서, 폰을 찾으려고 시도하면 에러가 발생해야 한다.")
    void findPawnNotOnTheBoard() {
        assertThatThrownBy(() -> board.findPiece(4, 0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("0 is out of range!");
    }

    @Test
    @DisplayName("음수 인덱스로 폰을 찾으려고 할 때, 에러가 발생해야 한다.")
    void findPawnWithNegativeIndex() {
        assertThatThrownBy(() -> board.findPiece(-1, 0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("-1 is out of range!");
    }


    @Test
    @DisplayName("보드를 초기화한 후, 폰들이 올바르게 생성되어야 한다.")
    void initializeBoard() {
        assertThat("pppppppp").isEqualTo(board.getWhitePawnsResult());
        assertThat("PPPPPPPP").isEqualTo(board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("보드를 초기화 한 뒤 출력된 결과가 예상된 결과와 같아야 한다.")
    void printBoard() {
        String expectedResult =
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr");

        String actualResult = board.print();
        assertThat(expectedResult).isEqualTo(actualResult);
    }

    private void addThePieceProperly(Piece newPiece, int rank, int file) {
        int sizeBeforeAddThePiece = board.size();
        board.add(newPiece, rank);
        assertThat(sizeBeforeAddThePiece + 1).isEqualTo(board.size());
        assertThat(newPiece).isEqualTo(board.findPiece(rank, file));
    }

}
