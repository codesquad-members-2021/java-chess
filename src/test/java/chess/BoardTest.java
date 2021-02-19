package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Pawn;

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
        Pawn white = new Pawn(Color.WHITE);
        board.addWhitePawn(white);
        assertAll(
                () -> assertThat(board.size()).isEqualTo(1),
                () -> assertThat(board.findWhitePawn(0)).isEqualTo(white)
        );

        Pawn black = new Pawn(Color.BLACK);
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
        expectedResult.append("........").append("\n")
                .append("pppppppp").append("\n")
                .append("........").append("\n")
                .append("........").append("\n")
                .append("........").append("\n")
                .append("........").append("\n")
                .append("PPPPPPPP").append("\n")
                .append("........");
        String result = board.print();
        System.out.println(result);
        assertThat(result).isEqualTo(expectedResult.toString());
    }

    @Test
    @DisplayName("잘못된 색의 pawn을 추가할 수 없다")
    void addWrongPawn() {
        Pawn black = new Pawn(Color.BLACK);
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> board.addWhitePawn(black));
    }
}
