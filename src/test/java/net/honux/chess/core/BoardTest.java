package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.entity.pieces.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

    Board board;

    @BeforeEach
    void generateBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("Pawn 이 보드에 정상적으로 등록되어야 한다.")
    void createPawnOntheBoard() {
        Pawn white = new Pawn(Color.WHITE);
        Pawn black = new Pawn(Color.BLACK);
        board.add(white);
        Assertions.assertAll(
                ()->assertThat(board.size()).isEqualTo(1),
                ()->assertThat(white).isEqualTo(board.findPawn(0).get()));
        board.add(black);
        Assertions.assertAll(
                ()->assertThat(board.size()).isEqualTo(2),
                ()->assertThat(black).isEqualTo(board.findPawn(1).get()));
    }


}
