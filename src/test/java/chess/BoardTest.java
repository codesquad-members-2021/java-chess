package chess;

import chess.pieces.Color;
import chess.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스 판에 1개 추가하면 size 가 1이다.")
    public void size_1() {
        board.add(new Pawn(Color.WHITE));
        assertThat(board.size())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("체스 판에 2개 추가하면 size 가 2이다.")
    public void size_2() {
        board.add(new Pawn(Color.WHITE));
        board.add(new Pawn(Color.BLACK));
        assertThat(board.size())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("체스 판에 추가한 pawn 을 findPawn 으로 조회할 수 있다.")
    public void findPawn() {
        Pawn whitePawn = new Pawn(Color.WHITE);
        Pawn blackPawn = new Pawn(Color.BLACK);

        board.add(whitePawn);
        board.add(blackPawn);
        assertAll(
                () -> assertThat(board.findPawn(0))
                        .isEqualTo(whitePawn),
                () -> assertThat(board.findPawn(1))
                        .isEqualTo(blackPawn),
                () -> assertThatExceptionOfType(IndexOutOfBoundsException.class)
                        .isThrownBy(() -> board.findPawn(-1)),
                () -> assertThatExceptionOfType(IndexOutOfBoundsException.class)
                        .isThrownBy(() -> board.findPawn(2))
        );
    }
}
