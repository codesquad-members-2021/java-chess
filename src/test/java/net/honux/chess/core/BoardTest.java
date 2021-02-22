package net.honux.chess.core;

import net.honux.chess.attribute.Color;
import net.honux.chess.attribute.Type;
import net.honux.chess.entity.pieces.Piece;
import net.honux.chess.util.StringUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static net.honux.chess.util.StringUtils.*;

class BoardTest {

    Board board;

    @BeforeEach
    void generateBoard() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("흰색 Pieces 16개 블랙 Pieces 16개가 정상적으로 initialize() 를 통해서 생성되는지 확인한다.")
    void checkPawnCount() {
        Assertions.assertAll(
                () -> assertThat(board.whitePiecesCount()).isEqualTo(Board.BOARD_SIZE * 2),
                () -> assertThat(board.blackPiecesCount()).isEqualTo(Board.BOARD_SIZE * 2));
    }

    @Test
    @DisplayName("Board 에서 색깔별로 Pawn 8개 씩을 정상적으로 찾는지 확인한다.")
    void checkCountOfPawns() {
        Assertions.assertAll(
                () -> assertThat(board.countOfPiece(Color.BLACK, Type.PAWN)).isEqualTo(8),
                () -> assertThat(board.countOfPiece(Color.WHITE, Type.PAWN)).isEqualTo(8)
        );
    }

    @Test
    @DisplayName("Board 에서 색깔별로 Knight 2개 씩을 정상적으로 찾는지 확인한다.")
    void checkCountOfKnights() {
        Assertions.assertAll(
                () -> assertThat(board.countOfPiece(Color.WHITE, Type.KNIGHT)).isEqualTo(2),
                () -> assertThat(board.countOfPiece(Color.BLACK, Type.KNIGHT)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Board 에서 색깔별로 Bishop 2개 씩을 정상적으로 찾는지 확인한다.")
    void checkCountOfBishop() {
        Assertions.assertAll(
                () -> assertThat(board.countOfPiece(Color.WHITE, Type.BISHOP)).isEqualTo(2),
                () -> assertThat(board.countOfPiece(Color.BLACK, Type.BISHOP)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Board 에서 색깔별로 Rook 2개 씩을 정상적으로 찾는지 확인한다.")
    void checkCountOfRook() {
        Assertions.assertAll(
                () -> assertThat(board.countOfPiece(Color.WHITE, Type.ROOK)).isEqualTo(2),
                () -> assertThat(board.countOfPiece(Color.BLACK, Type.ROOK)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Board 에서 색깔별로 King 1개 씩을 정상적으로 찾는지 확인한다.")
    void checkCountOfKing() {
        Assertions.assertAll(
                () -> assertThat(board.countOfPiece(Color.WHITE, Type.KING)).isEqualTo(1),
                () -> assertThat(board.countOfPiece(Color.BLACK, Type.KING)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Board 에서 색깔별로 Queen 1개 씩을 정상적으로 찾는지 확인한다.")
    void checkCountOfQueen() {
        Assertions.assertAll(
                () -> assertThat(board.countOfPiece(Color.WHITE, Type.QUEEN)).isEqualTo(1),
                () -> assertThat(board.countOfPiece(Color.BLACK, Type.QUEEN)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("보드에 올려진 출력 메세지가 정상적으로 리턴되는지 확인한다.")
    void checkBoardPrintMessage() {
        String expectedMessage =
                "RNBQKBNR" + NEWLINE +
                "PPPPPPPP" + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "pppppppp" + NEWLINE +
                "rnbqkbnr" + NEWLINE ;
        assertThat(board.getBoardStatusToString()).isEqualTo(expectedMessage);
        // TestCode 에서 출력 해달라는 요구사항 을 만족시키기 위해 작성
        board.print();
    }

    @Test
    @DisplayName("findPiece 를 통해 원하는 Piece 를 찾을 수 있는지 확인한다.")
    void checkFindPieceMethod() {
        Assertions.assertAll(
                () -> assertThat(board.findPiece("a8").get()).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(board.findPiece("h8").get()).isEqualTo(Piece.createBlackRook()),
                () -> assertThat(board.findPiece("a1").get()).isEqualTo(Piece.createWhiteRook()),
                () -> assertThat(board.findPiece("h1").get()).isEqualTo(Piece.createWhiteRook())
                );
    }

    @Test
    @DisplayName("보드위에서 말들이 정확히 놓여지는지 확인한다.")
    void checkCorrectPosition() {
        board.initializeEmpty();
        String position = "b5";
        board.move(position , Piece.createBlackRook());
        assertThat(board.findPiece(position).get()).isEqualTo(Piece.createBlackRook());
    }
}
