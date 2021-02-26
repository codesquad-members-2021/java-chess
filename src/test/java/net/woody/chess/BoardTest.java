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
    void initializedBoard() {
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
    @DisplayName("보드를 초기화 한 뒤 출력된 체스판 상태가 예상된 결과와 같아야 한다.")
    void printBoardState() {
        String expectedResult =
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("........") +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr");

        assertThat(board.toString()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("생성한 체스말을 빈 체스판 임의의 위치로 이동시킬 수 있어야 한다.")
    void locatePieceOnTheEmptyBoard() {
        this.board = Board.createEmtpyBoard();
        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.toString());
    }

    @Test
    @DisplayName("흰색과 검은색 체스말의 총 스코어를 각각 계산한다.")
    void calculatePoint() {
        this.board = Board.createEmtpyBoard();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(7.0);

        System.out.println(board.toString());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}
