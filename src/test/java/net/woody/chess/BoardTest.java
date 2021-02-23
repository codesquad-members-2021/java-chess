package net.woody.chess;

import net.woody.pieces.Piece;
import org.junit.jupiter.api.*;

import static net.woody.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    @DisplayName("보드에 있는 체스말들을 정상적으로 찾을 수 있어야 한다.")
    void findPawnOnTheBoard() {
        assertAll(
                () -> {
                    Piece shouldBeBlackRook = board.findPiece(0, 0);
                    assertThat(shouldBeBlackRook.isBlack()).isTrue();
                    assertThat(shouldBeBlackRook.getRepresentation()).isEqualTo('R');
                }, () -> {
                    Piece shouldBeWhitePawn = board.findPiece(6, 0);
                    assertThat(shouldBeWhitePawn.isWhite()).isTrue();
                    assertThat(shouldBeWhitePawn.getRepresentation()).isEqualTo('p');
                });
    }

    @Test
    @DisplayName("체스말이 존재하지 않는 위치에서, 체스말을 찾으려고 시도하면 에러가 발생해야 한다.")
    void findPieceNotOnTheBoard() {
        assertThatThrownBy(() -> board.findPiece(4, 0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("0 is out of range!");
    }

    @Test
    @DisplayName("음수 인덱스로 체스말을 찾으려고 할 때, 에러가 발생해야 한다.")
    void findPieceWithNegativeIndex() {
        assertThatThrownBy(() -> board.findPiece(-1, 0))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("-1 is out of range!");
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
}
