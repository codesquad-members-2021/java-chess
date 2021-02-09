package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Pointer;
import net.honux.chess.entity.pieces.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoardTest {

    Board board;

    @BeforeEach
    void generateBoard() {
        board = new Board();
    }


    @Test
    @DisplayName("Pawn 이 보드에 정상적으로 등록되어야 한다.")
    void create() {
        Pawn white = new Pawn('p', Color.WHITE, new Pointer('a', 2));
        board.add(white);
        Assertions.assertEquals(1, board.size());
        Assertions.assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn('p', Color.BLACK, new Pointer('a', 2));
        board.add(black);
        Assertions.assertEquals(2, board.size());
        Assertions.assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("Pawn 이 없는데도 가져오려고 할때 IndexOutOfBoundsException 예외를 리턴한다.")
    void exceptionTest() {
        assertThatThrownBy(() -> {
            board.findPawn(1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }


}
