package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;


class BoardTest {
    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("흰색, 검은색 Pawn을 생성해 board에 추가한다")
    void createPawn() {
        Piece white = Piece.createWhitePawn();
        board.addWhitePawn(white);
        assertAll(
                () -> assertThat(board.size()).isEqualTo(1),
                () -> assertThat(board.findWhitePawn(0)).isEqualTo(white)
        );

        Piece black = Piece.createBlackPawn();
        board.addBlackPawn(black);
        assertAll(
                () -> assertThat(board.size()).isEqualTo(2),
                () -> assertThat(board.findBlackPawn(0)).isEqualTo(black)
        );
    }

    @Test
    @DisplayName("게임을 시작하고, 대표값이 맞게 나오는지 확인한다")
    void initialize() {
        board.initialize();
        assertAll(
                () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
                () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }

    @Test
    @DisplayName("board를 초기화 하고 print한다")
    void print() {
        board.initialize();
        StringBuilder expectedResult = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        expectedResult.append("........").append(newLine)
                .append("pppppppp").append(newLine)
                .append("........").append(newLine)
                .append("........").append(newLine)
                .append("........").append(newLine)
                .append("........").append(newLine)
                .append("PPPPPPPP").append(newLine)
                .append("........");
        String result = board.print();
        System.out.println(result);
        assertThat(result).isEqualTo(expectedResult.toString());
    }

    @Test
    @DisplayName("잘못된 색의 pawn을 추가할 수 없다")
    void addWrongPawn() {
        Piece black = Piece.createBlackPawn();
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> board.addWhitePawn(black));
    }
}
