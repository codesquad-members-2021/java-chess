package kr.codesquad.freddie.chess.board;

import kr.codesquad.freddie.chess.piece.Color;
import kr.codesquad.freddie.chess.piece.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    private static final int MAX_SIZE = Board.RANK_SIZE * File.SIZE;

    @BeforeEach
    void setBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("1개 부터 64개까지 넣으면서 사이즈 일치하는지 확인")
    void add() {
        for (int i = 0; i <= MAX_SIZE; i++) {
            Board board = new Board();

            for (int j = 0; j < i; j++) {
                board.add(new Pawn());
            }
            assertThat(board.size())
                    .isEqualTo(i);

            System.out.println(board);
        }
    }

    @Test
    @DisplayName("8개가 넘어가면 다음 줄로 넘어가기 때문에 에러가 발생하면 안된다.")
    void add_fillRank() {
        int size = File.SIZE + 1;
        for (int i = 1; i <= size; i++) {
            board.add(new Pawn());
            assertThat(board.size())
                    .isEqualTo(i);
        }
    }

    @Test
    void add_outOfRange() {
        for (int i = 0; i < MAX_SIZE; i++) {
            board.add(new Pawn());
        }

        assertThatThrownBy(() -> board.add(new Pawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("더 이상 추가할 수 없습니다. 현재 크기 : 64");
    }

    @Test
    @DisplayName("하나만 추가하여 탐색")
    void findPawn_one() {
        Pawn white = new Pawn(Color.WHITE);
        board.add(white);
        assertAll(
                () -> assertThat(board.size()).isEqualTo(1),
                () -> assertThat(board.findPawn('a', 8)).isEqualTo(white)
        );
    }

    @Test
    @DisplayName("하나 이상 추가하여 탐색")
    void findPawn_moreThanOne() {
        Pawn white = new Pawn(Color.WHITE);
        board.add(white);
        Pawn black = new Pawn(Color.BLACK);
        board.add(black);

        assertAll(
                () -> assertThat(board.size()).isEqualTo(2),
                () -> assertThat(board.findPawn('a', 8)).isEqualTo(white),
                () -> assertThat(board.findPawn('b', 8)).isEqualTo(black)
        );
    }

    @Test
    void initialize() {
        board.initialize();

        assertAll(
                () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
                () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }
}
