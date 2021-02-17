package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Color;
import pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;


class BoardTest {
    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("흰색 Pawn을 생성해 board에 추가한다")
    void createPawnOnTheBoard() {
        Pawn white = new Pawn(Color.WHITE);
        board.addWhitePawn(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findWhitePawn(0)).isEqualTo(white);


        Pawn black = new Pawn(Color.BLACK);
        board.addBlackPawn(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findBlackPawn(0)).isEqualTo(black);
    }

    @Test
    @DisplayName("게임을 시작하고, 대표값이 맞게 나오는지 확인한다")
    void initialize() {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("board를 초기화 하고 print한다")
    void print() {
        board.initialize();
        board.print();
    }
}
