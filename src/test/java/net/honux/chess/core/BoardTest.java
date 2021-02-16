package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.entity.pieces.Pawn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                () -> assertThat(board.whitePawnSize()).isEqualTo(9),
                () -> assertThat(board.findWhitePawn(8).get()).isEqualTo(white),
                () -> assertThat(board.blackPawnSize()).isEqualTo(9),
                () -> assertThat(board.findBlackPawn(8).get()).isEqualTo(black)
        );
    }

    @Test
    @DisplayName("흰색폰 8개 블랙폰 8개가 정상적으로 initialize() 를 통해서 생성되는지 확인한다.")
    void checkPawnCount() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat(board.whitePawnSize()).isEqualTo(8),
                () -> assertThat(board.blackPawnSize()).isEqualTo(8));
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

    @Test
    @DisplayName("보드에 올려진 출력 메세지가 정상적으로 리턴되는지 확인한다.")
    void checkBoardPrintMessage() {
        board.initialize();
        String expectedMessage =
                "********\n" +
                "PPPPPPPP\n" +
                "********\n" +
                "********\n" +
                "********\n" +
                "********\n" +
                "pppppppp\n" +
                "********";
        assertThat(board.getBoardStatusToString()).isEqualTo(expectedMessage);
        // TestCode 에서 출력 해달라는 요구사항 을 만족시키기 위해 작성
        System.out.println(board.getBoardStatusToString());
    }
}
