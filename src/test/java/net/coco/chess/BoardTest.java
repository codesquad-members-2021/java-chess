package net.coco.chess;


import net.coco.pieces.Piece;
import net.coco.pieces.Piece.Color;
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
                () -> assertThat(board.getPieceCount(Color.WHITE, PieceType.PAWN)).isEqualTo(8),
                () -> assertThat(board.getPieceCount(Color.WHITE, PieceType.KING)).isEqualTo(1),
                () -> assertThat(board.getPieceCount(Color.NO_COLOR, PieceType.NO_PIECE)).isEqualTo(32)
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
                () -> assertThat(findPiece.getPieceType()).isEqualTo(makeBlackRook.getPieceType()),
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

        assertThat(board.calculateScore(Color.BLACK)).isEqualTo(2.5);

    }

    @Test
    void getWhitePiecesSortByScore() {
        board.initializeWithPieces();
        List<Piece> getWhitePiecesSortByScore = board.getWhitePiecesSortByScore();

        Assertions.assertAll(
                () -> assertThat(getWhitePiecesSortByScore.get(0)).isEqualTo(Piece.createWhiteQueen()),
                () -> assertThat(getWhitePiecesSortByScore.get(1)).isEqualTo(Piece.createWhiteRook()),
                () -> assertThat(getWhitePiecesSortByScore.get(2)).isEqualTo(Piece.createWhiteRook()),
                () -> assertThat(getWhitePiecesSortByScore.get(3)).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(getWhitePiecesSortByScore.get(4)).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(getWhitePiecesSortByScore.get(5)).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(getWhitePiecesSortByScore.get(6)).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(getWhitePiecesSortByScore.get(7)).isEqualTo(Piece.createWhitePawn()),
                () -> assertThat(getWhitePiecesSortByScore.get(8)).isEqualTo(Piece.createWhitePawn()),
                () -> assertThat(getWhitePiecesSortByScore.get(15)).isEqualTo(Piece.createWhiteKing())
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
