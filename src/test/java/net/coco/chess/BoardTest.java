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
                () -> assertThat(board.getPieceCount(Color.WHITE, PieceType.KNIGHT)).isEqualTo(2),
                () -> assertThat(board.getPieceCount(Color.WHITE, PieceType.QUEEN)).isEqualTo(1),
                () -> assertThat(board.getPieceCount(Color.WHITE, PieceType.ROOK)).isEqualTo(2),
                () -> assertThat(board.getPieceCount(Color.WHITE, PieceType.BISHOP)).isEqualTo(2),

                () -> assertThat(board.getPieceCount(Color.BLACK, PieceType.PAWN)).isEqualTo(8),
                () -> assertThat(board.getPieceCount(Color.BLACK, PieceType.KING)).isEqualTo(1),
                () -> assertThat(board.getPieceCount(Color.BLACK, PieceType.KNIGHT)).isEqualTo(2),
                () -> assertThat(board.getPieceCount(Color.BLACK, PieceType.QUEEN)).isEqualTo(1),
                () -> assertThat(board.getPieceCount(Color.BLACK, PieceType.ROOK)).isEqualTo(2),
                () -> assertThat(board.getPieceCount(Color.BLACK, PieceType.BISHOP)).isEqualTo(2),

                () -> assertThat(board.getPieceCount(Color.NO_COLOR, PieceType.NO_PIECE)).isEqualTo(32)
        );

    }

    @Test
    @DisplayName("point가 체스판을 벗어난 경우")
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
        List<Piece> getWhitePieces = board.getWhitePiecesSortByScore();

        Assertions.assertAll(
                () -> assertThat(getWhitePieces.get(0)).isEqualTo(Piece.createWhiteQueen()),
                () -> assertThat(getWhitePieces.get(1)).isEqualTo(Piece.createWhiteRook()),
                () -> assertThat(getWhitePieces.get(2)).isEqualTo(Piece.createWhiteRook()),
                () -> assertThat(getWhitePieces.get(3)).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(getWhitePieces.get(4)).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(getWhitePieces.get(5)).isEqualTo(Piece.createWhiteBishop()),
                () -> assertThat(getWhitePieces.get(6)).isEqualTo(Piece.createWhiteKnight()),
                () -> assertThat(getWhitePieces.get(7)).isEqualTo(Piece.createWhitePawn()),
                () -> assertThat(getWhitePieces.get(8)).isEqualTo(Piece.createWhitePawn()),
                () -> assertThat(getWhitePieces.get(15)).isEqualTo(Piece.createWhiteKing())
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
