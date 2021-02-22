package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("초기화 했을 때 Board에 흑 폰 8개 백 폰 8개가 있는지 확인")
    void initialize() {
        board.initialize();
        assertAll(
                () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
                () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }

    @Test
    @DisplayName("초기화 했을때 Board출력이 제대로 되는지 확인")
    void print() {
        board.initialize();
        assertThat(board.printBoard()).isEqualTo(
                "........\n" +
                "pppppppp\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "PPPPPPPP\n" +
                "........\n");
    }

    @Test
    @DisplayName("Board에 흰색 폰 한개와 흑색 폰 한개가 제대로 추가되는지 확인")
    void create() {
        Piece white = new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        Piece black = new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
        verifyAddWhitePawn(white, 1);
        verifyAddBlackPawn(black, 2);
    }

    void verifyAddWhitePawn(Piece whitePawn, int size) {
        board.addWhitePawn(whitePawn);
        assertAll(
                () -> assertThat(board.findWhitePawn(0)).isEqualTo(whitePawn),
                () -> assertThat(board.size()).isEqualTo(size)
        );
    }

    void verifyAddBlackPawn(Piece blackPawn, int size) {
        board.addBlackPawn(blackPawn);
        assertAll(
                () -> assertThat(board.findBlackPawn(0)).isEqualTo(blackPawn),
                () -> assertThat(board.size()).isEqualTo(size)
        );
    }
}
