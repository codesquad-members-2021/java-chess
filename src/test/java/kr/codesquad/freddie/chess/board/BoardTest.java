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

    @BeforeEach
    void setBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("1개 부터 64개까지 넣으면서 사이즈 일치하는지 확인")
    void add() {
        int size = 8 * 8;

        for (int i = 0; i <= size; i++) {
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
        int size = 9;
        for (int i = 1; i <= size; i++) {
            board.add(new Pawn());
            assertThat(board.size())
                    .isEqualTo(i);
        }
    }

    @Test
    void add_outOfRange() {
        int size = 8 * 8;

        for (int i = 0; i < size; i++) {
            board.add(new Pawn());
        }

        assertThatThrownBy(() -> board.add(new Pawn()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("더 이상 추가할 수 없습니다. 현재 크기 : 64");
    }

    @Test
    public void findPawn() {
        Pawn white = new Pawn(Color.WHITE);
        board.add(white);
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn('a', 8)).isEqualTo(white);

        Pawn black = new Pawn(Color.BLACK);
        board.add(black);
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn('b', 8)).isEqualTo(black);
        assertEquals(2, board.size());
    }
}
