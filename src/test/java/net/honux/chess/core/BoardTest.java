package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.entity.pieces.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    Board board;

    @BeforeEach
    void generateBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("Pawn 이 보드에 정상적으로 등록되어야 한다.")
    void createPawnOnTheBoard() {
        board.initialize();
        Pawn white = new Pawn(Color.WHITE);
        Pawn black = new Pawn(Color.BLACK);
        board.add(white);
        board.add(black);
        Assertions.assertAll(
                () -> assertThat(board.whitePawnsize()).isEqualTo(9),
                () -> assertThat(white).isEqualTo(board.findWhitePawn(8).get()),
                () -> assertThat(board.blackPawnsize()).isEqualTo(9),
                () -> assertThat(black).isEqualTo(board.findBlackPawn(8).get())
        );
    }

    @Test
    @DisplayName("흰색폰 8개 블랙폰 8개가 정상적으로 initialize() 를 통해서 생성되는지 확인한다.")
    void checkPawnCount() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat(board.whitePawnsize()).isEqualTo(8),
                () -> assertThat(board.blackPawnsize()).isEqualTo(8));
    }

    @Test
    @DisplayName("보드에 올려진 폰들의 Representation 이 정상적으로 출력되는지 확인한다.")
    void checkPawnRepresentationOnTheBoard() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
                () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }
}
