package net.woody.chess;

import net.woody.pieces.Piece;
import net.woody.pieces.Piece.Color;
import net.woody.pieces.Type;
import org.junit.jupiter.api.*;

import static net.woody.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BoardTest {

    private Board board;

    @BeforeEach
    void setup() {
        this.board = Board.createInitBoard();
    }

    @Test
    @DisplayName("보드를 초기화한 후, 체스말이 총 32개여야 한다.")
    void checkTheNumberOfPieces() {
        assertThat(board.size()).isEqualTo(32);
    }

    @Test
    @DisplayName("보드를 초기화한 후, 특정 체스말의 갯수를 셀 수 있어야 한다")
    void checkTheNumberOfSpecificPiece() {
        assertAll(() -> {
            int actualWhitePawnNum = board.numOfSpecificPiece(Color.WHITE, Type.PAWN);
            assertThat(actualWhitePawnNum).isEqualTo(8);
        }, () -> {
            int actualBlackQueenNum = board.numOfSpecificPiece(Color.BLACK, Type.QUEEN);
            assertThat(actualBlackQueenNum).isEqualTo(1);
        }, () -> {
            int actualBlankNum = board.numOfSpecificPiece(Color.NOCOLOR, Type.NO_PIECE);
            assertThat(actualBlankNum).isEqualTo(32);
        });
    }

    @Test
    @DisplayName("보드에 있는 체스말들을 정상적으로 찾을 수 있어야 한다.")
    void findPawnOnTheBoard() {
        assertAll(
                () -> {
                    Piece actualBlackRook = board.findPiece("a8");
                    assertThat(actualBlackRook).isEqualTo(Piece.createBlackRook());
                }, () -> {
                    Piece actualBlackRook = board.findPiece("h8");
                    assertThat(actualBlackRook).isEqualTo(Piece.createBlackRook());
                }, () -> {
                    Piece actualWhiteRook = board.findPiece("a1");
                    assertThat(actualWhiteRook).isEqualTo(Piece.createWhiteRook());
                }, () -> {
                    Piece actualWhiteRook = board.findPiece("h1");
                    assertThat(actualWhiteRook).isEqualTo(Piece.createWhiteRook());
                });
    }

    @Test
    @DisplayName("음수 인덱스로 체스말을 찾으려고 할 때, 에러가 발생해야 한다.")
    void findPieceWithNegativeIndex() {
        assertThatThrownBy(() -> board.findPiece("a-1"))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range!");
    }

    // TODO : expectedResult 대신 expect, actualResult 대신 actual도 좋다
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

        String actualResult = board.showBoard();
        assertThat(expectedResult).isEqualTo(actualResult);
    }
}
