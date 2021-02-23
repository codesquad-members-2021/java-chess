package net.coco.chess;


import net.coco.pieces.Piece;
import net.coco.pieces.PieceType;
import net.coco.printer.PrintChess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static net.coco.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BoardTest {

    private Board board;

    @BeforeEach
    void makeBoard() {
        board = new Board();
    }

    @Test
    void printChessBoard() {
        board.initializeWithPieces();
        String blank = appendNewLine("........");
        assertThat(
                PrintChess.printBoard(board)
        ).isEqualTo(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blank + blank + blank + blank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr")
        );
    }

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
    void getPiecesCount() {
        board.initializeWithPieces();
        Assertions.assertAll(
                () -> assertThat(board.getPieceCount(Piece.WHITE, PieceType.PAWN)).isEqualTo(8),
                () -> assertThat(board.getPieceCount(Piece.WHITE, PieceType.KING)).isEqualTo(1),
                () -> assertThat(board.getPieceCount(Piece.NO_COLOR, PieceType.NO_PIECE)).isEqualTo(32)
        );

    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회시 올바르지 않은 point 입력시")
    void getPieceFromWrongPoint() {
        board.initializeWithPieces();
        assertThatThrownBy(
                () -> board.getPieceFromPoint("f9")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 point가 아닙니다.");

    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회")
    void getPieceFromPoint() {
        board.initializeWithPieces();
        Piece findPiece = board.getPieceFromPoint("a8");
        Piece makeBlackRook = Piece.createBlackRook();
        Assertions.assertAll(
                () -> assertThat(findPiece.getRepresentation()).isEqualTo(makeBlackRook.getRepresentation()),
                () -> assertThat(findPiece.getColor()).isEqualTo(makeBlackRook.getColor())
        );
    }

    @Test
    void move() {
        board.initializeEmpty();
        Piece blackPawn = Piece.createBlackPawn();
        board.move("a8", blackPawn);

        assertThat(board.getPieceFromPoint("a8")).isEqualTo(blackPawn);
    }

    @Test
    void calculateScore() {
        board.initializeEmpty();
        board.move("a8", Piece.createBlackPawn());
        board.move("a7", Piece.createBlackPawn());
        board.move("a6", Piece.createBlackPawn());
        board.move("g8", Piece.createBlackKing());
        board.move("g7", Piece.createBlackPawn());
        board.move("g6", Piece.createBlackPawn());
        board.move("g5", Piece.createWhitePawn());

        assertThat(board.calculateScore(Piece.BLACK)).isEqualTo(2.5);

    }

    @Test
    void getWhitePiecesSortByScore() {
        board.initializeWithPieces();
        List<Piece> getWhitePiecesSortByScore = board.getWhitePiecesSortByScore();

        Assertions.assertAll(
                () -> assertThat(Piece.createWhiteQueen()).isEqualTo(getWhitePiecesSortByScore.get(0)),
                () -> assertThat(Piece.createWhiteRook()).isEqualTo(getWhitePiecesSortByScore.get(1)),
                () -> assertThat(Piece.createWhiteRook()).isEqualTo(getWhitePiecesSortByScore.get(2)),
                () -> assertThat(Piece.createWhiteKnight()).isEqualTo(getWhitePiecesSortByScore.get(3)),
                () -> assertThat(Piece.createWhiteBishop()).isEqualTo(getWhitePiecesSortByScore.get(4)),
                () -> assertThat(Piece.createWhiteBishop()).isEqualTo(getWhitePiecesSortByScore.get(5)),
                () -> assertThat(Piece.createWhiteKnight()).isEqualTo(getWhitePiecesSortByScore.get(6)),
                () -> assertThat(Piece.createWhitePawn()).isEqualTo(getWhitePiecesSortByScore.get(7)),
                () -> assertThat(Piece.createWhitePawn()).isEqualTo(getWhitePiecesSortByScore.get(8)),
                () -> assertThat(Piece.createWhiteKing()).isEqualTo(getWhitePiecesSortByScore.get(15))
                );

    }


    @Test
    void checkBlackColor() {
        assertThat(Piece.createBlackBishop().isBlack()).isTrue();
    }

    @Test
    void checkWhiteColor() {
        assertThat(Piece.createWhiteBishop().isWhite()).isTrue();
    }


}
