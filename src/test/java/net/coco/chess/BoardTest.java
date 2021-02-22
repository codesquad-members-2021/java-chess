package net.coco.chess;


import net.coco.pieces.Piece;
import net.coco.pieces.PieceType;
import net.coco.printer.PrintChess;
import net.coco.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.coco.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BoardTest {

    private Board board;

    @BeforeEach
    void makeBoard() {
        board = new Board();
        board.initialize();
    }

    @Test
    void initialize() {
        board.initialize();
        PrintChess.printBoard(board);

    }

    @Test
    void printChessBoard() {
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
        Assertions.assertAll(
                () -> assertThat(board.getPieceCount(Piece.WHITE, PieceType.PAWN)).isEqualTo(8),
                () -> assertThat(board.getPieceCount(Piece.WHITE, PieceType.KING)).isEqualTo(1),
                () -> assertThat(board.getPieceCount(Piece.NO_COLOR, PieceType.NO_PIECE)).isEqualTo(32)
        );

    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회시 올바르지 않은 point 입력시")
    void getPieceFromWrongPoint() {

        assertThatThrownBy(
                () -> board.getPieceFromPoint("f9")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 point가 아닙니다.");

    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회")
    void getPieceFromPoint() {
        Piece findPiece = board.getPieceFromPoint("a8");
        Piece makeBlackRook = Piece.createBlackRook();
        Assertions.assertAll(
                ()->assertThat(findPiece.getRepresentation()).isEqualTo(makeBlackRook.getRepresentation()),
                ()->assertThat(findPiece.getColor()).isEqualTo(makeBlackRook.getColor())
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
