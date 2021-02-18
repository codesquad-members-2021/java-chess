package net.honux.chess.core;

import net.honux.chess.entity.pieces.Piece;
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
        Piece whitePawn = Piece.createWhitePawn();
        Piece blackPawn = Piece.createBlackPawn();
        board.add(whitePawn);
        board.add(blackPawn);
        Assertions.assertAll(
                () -> assertThat(board.whitePawnSize()).isEqualTo(Board.BOARD_SIZE*2+1),
                () -> assertThat(board.findWhitePawn(Board.BOARD_SIZE*2).get()).isEqualTo(whitePawn),
                () -> assertThat(board.blackPawnSize()).isEqualTo(Board.BOARD_SIZE*2+1),
                () -> assertThat(board.findBlackPawn(Board.BOARD_SIZE*2).get()).isEqualTo(blackPawn)
        );
    }

    @Test
    @DisplayName("흰색 Pices 16개 블랙 Pices 16개가 정상적으로 initialize() 를 통해서 생성되는지 확인한다.")
    void checkPawnCount() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat(board.whitePawnSize()).isEqualTo(Board.BOARD_SIZE*2),
                () -> assertThat(board.blackPawnSize()).isEqualTo(Board.BOARD_SIZE*2));
    }

    @Test
    @DisplayName("보드에 올려진 조각들의 Representation 이 정상적으로 출력되는지 확인한다.")
    void checkPawnRepresentationOnTheBoard() {
        board.initialize();
        Assertions.assertAll(
                () -> assertThat(board.getBlackPiecesExceptPawns()).isEqualTo("RNBQKBNR"),
                ()->assertThat(board.getWhitePiecesExceptPawns()).isEqualTo("rnbqkbnr"),
                () -> assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp"),
                () -> assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP")
        );
    }


    @Test
    @DisplayName("보드에 올려진 출력 메세지가 정상적으로 리턴되는지 확인한다.")
    void checkBoardPrintMessage() {
        board.initialize();
        String expectedMessage =
                "RNBQKBNR\n" +
                "PPPPPPPP\n" +
                "********\n" +
                "********\n" +
                "********\n" +
                "********\n" +
                "pppppppp\n" +
                "rnbqkbnr\n";
        assertThat(board.getBoardStatusToString()).isEqualTo(expectedMessage);
        // TestCode 에서 출력 해달라는 요구사항 을 만족시키기 위해 작성
        board.print();
    }
}
